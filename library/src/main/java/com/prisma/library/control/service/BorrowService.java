package com.prisma.library.control.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.prisma.library.control.mapper.BookMapper;
import com.prisma.library.control.mapper.UserMapper;
import com.prisma.library.control.repository.BorrowRepository;
import com.prisma.library.entity.dto.BookDto;
import com.prisma.library.entity.dto.UserDto;
import com.prisma.library.entity.table.Book;
import com.prisma.library.entity.table.Borrow;
import com.prisma.library.entity.table.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BorrowService {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

    private final BorrowRepository borrowRepository;
    private final UserService userService;
    private final BookService bookService;

    public Set<UserDto> retrieveUsersBorrowAtLeastOne() {

        return borrowRepository.findAll()
            .stream()
            .map(borrow -> UserMapper.getInstance().userToUserDto(borrow.getUser()))
            .collect(Collectors.toSet());

    }

    public Set<UserDto> retrieveActiveUsersHasNoBorrowingCurrently() {

        Timestamp currentTime = Timestamp.from(LocalDateTime.now().toInstant(ZoneOffset.UTC));
        return borrowRepository.findAllByBorrowedToLessThan(currentTime)
            .stream()
            .filter(borrow -> borrow.getUser().getActive())
            .map(borrow -> UserMapper.getInstance().userToUserDto(borrow.getUser()))
            .collect(Collectors.toSet());
    }

    public Set<UserDto> retrieveUsersBorrowedOnGivenDate(String givenDate) throws ParseException {
        Timestamp date = Timestamp.from(dateFormat.parse(givenDate).toInstant());

        return borrowRepository.findAllByBorrowedFromEquals(date)
            .stream()
            .map(borrow -> UserMapper.getInstance().userToUserDto(borrow.getUser()))
            .collect(Collectors.toSet());

    }

    public Set<BookDto> retrieveBooksBorrowedByUserOnGivenDateRange(String firstName, String lastName, String startDate,
        String endDate) throws ParseException {

        Timestamp sDate = Timestamp.from(dateFormat.parse(startDate).toInstant());
        Timestamp eDate = Timestamp.from(dateFormat.parse(endDate).toInstant());
        User user = userService.retrieveUser(firstName, lastName);

        return borrowRepository.findAllByBorrowedFromGreaterThanAndBorrowedToLessThanAndUser(sDate, eDate, user)
            .stream()
            .map(borrow -> BookMapper.getInstance().bookToBookDto(borrow.getBook()))
            .collect(Collectors.toSet());

    }

    public Set<BookDto> retrieveAvailableBooks() {
        Timestamp currentTime = Timestamp.from(LocalDateTime.now().toInstant(ZoneOffset.UTC));

        Set<Book> books = bookService.retrieveAllBook();

        Set<Book> returnedBooks = borrowRepository.findAllByBorrowedToLessThan(currentTime)
            .stream()
            .map(Borrow::getBook)
            .collect(Collectors.toSet());

        Set<Book> unReturnedBooks = borrowRepository.findAllByBorrowedToGreaterThan(currentTime)
            .stream()
            .map(Borrow::getBook)
            .collect(Collectors.toSet());

        Set<Book> allBorrowedBooks =
            borrowRepository.findAll().stream().map(Borrow::getBook).collect(Collectors.toSet());

        returnedBooks.removeAll(unReturnedBooks);

        Set<BookDto> resultSet = new HashSet<>(returnedBooks.stream()
            .map(book -> BookMapper.getInstance().bookToBookDto(book))
            .collect(Collectors.toSet()));

        books.removeAll(allBorrowedBooks);

        resultSet.addAll(
            books.stream().map(book -> BookMapper.getInstance().bookToBookDto(book)).collect(Collectors.toSet()));

        return resultSet;

    }
}
