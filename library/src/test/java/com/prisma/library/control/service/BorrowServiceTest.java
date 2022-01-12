package com.prisma.library.control.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.prisma.library.control.repository.BorrowRepository;
import com.prisma.library.entity.dto.BookDto;
import com.prisma.library.entity.dto.UserDto;
import com.prisma.library.entity.table.Book;
import com.prisma.library.entity.table.Borrow;
import com.prisma.library.entity.table.User;

import lombok.SneakyThrows;

@ExtendWith(MockitoExtension.class)
class BorrowServiceTest {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

    @Mock
    private BorrowRepository borrowRepository;

    @Mock
    private UserService userService;

    @Mock
    private BookService bookService;

    @InjectMocks
    private BorrowService borrowService;

    @Test
    void retrieveUsersBorrowAtLeastOne() {

        User user = new User();
        user.setFirstName("ali");
        user.setLastName("can");

        User user1 = new User();
        user1.setFirstName("gul");
        user1.setLastName("er");

        Book book = new Book();
        book.setTitle("exampleBook");

        Borrow borrow = new Borrow();
        borrow.setUser(user);
        borrow.setBook(book);

        Borrow borrow1 = new Borrow();
        borrow1.setBook(book);
        borrow1.setUser(user);

        Borrow borrow2 = new Borrow();
        borrow2.setBook(book);
        borrow2.setUser(user1);

        List<Borrow> borrowList = new ArrayList<>();
        borrowList.add(borrow);
        borrowList.add(borrow1);
        borrowList.add(borrow2);

        Mockito.when(borrowRepository.findAll()).thenReturn(borrowList);

        Set<UserDto> userDtoSet = borrowService.retrieveUsersBorrowAtLeastOne();

        Assertions.assertEquals(2, userDtoSet.size());
    }

    @Test
    @SneakyThrows
    void retrieveActiveUsersHasNoBorrowingCurrently() {

        User user = new User();
        user.setFirstName("ali");
        user.setLastName("can");
        user.setActive(true);

        User user1 = new User();
        user1.setFirstName("gul");
        user1.setLastName("er");
        user1.setActive(false);

        Book book = new Book();
        book.setTitle("exampleBook");

        Borrow borrow = new Borrow();
        borrow.setUser(user);
        borrow.setBook(book);
        borrow.setBorrowedTo(Timestamp.from(dateFormat.parse("12/01/2020").toInstant()));

        Borrow borrow1 = new Borrow();
        borrow1.setBook(book);
        borrow1.setUser(user);
        borrow1.setBorrowedTo(Timestamp.from(dateFormat.parse("12/01/2020").toInstant()));

        Borrow borrow2 = new Borrow();
        borrow2.setBook(book);
        borrow2.setUser(user1);
        borrow1.setBorrowedTo(Timestamp.from(dateFormat.parse("12/01/2020").toInstant()));

        List<Borrow> borrowList = new ArrayList<>();
        borrowList.add(borrow);
        borrowList.add(borrow1);
        borrowList.add(borrow2);

        Mockito.when(borrowRepository.findAllByBorrowedToLessThan(Mockito.any())).thenReturn(borrowList);

        Set<UserDto> userDtoSet = borrowService.retrieveActiveUsersHasNoBorrowingCurrently();

        Assertions.assertEquals(1, userDtoSet.size());
    }

    @Test
    @SneakyThrows
    void retrieveUsersBorrowedOnGivenDate() {

        User user = new User();
        user.setFirstName("ali");
        user.setLastName("can");
        user.setActive(true);

        User user1 = new User();
        user1.setFirstName("gul");
        user1.setLastName("er");
        user1.setActive(false);

        Book book = new Book();
        book.setTitle("exampleBook");

        Borrow borrow = new Borrow();
        borrow.setUser(user);
        borrow.setBook(book);
        borrow.setBorrowedTo(Timestamp.from(dateFormat.parse("12/01/2020").toInstant()));
        borrow.setBorrowedFrom(Timestamp.from(dateFormat.parse("11/01/2020").toInstant()));

        Borrow borrow1 = new Borrow();
        borrow1.setBook(book);
        borrow1.setUser(user);
        borrow1.setBorrowedTo(Timestamp.from(dateFormat.parse("12/01/2020").toInstant()));
        borrow1.setBorrowedFrom(Timestamp.from(dateFormat.parse("11/01/2020").toInstant()));

        Borrow borrow2 = new Borrow();
        borrow2.setBook(book);
        borrow2.setUser(user1);
        borrow1.setBorrowedTo(Timestamp.from(dateFormat.parse("12/01/2020").toInstant()));
        borrow1.setBorrowedFrom(Timestamp.from(dateFormat.parse("11/01/2020").toInstant()));

        List<Borrow> borrowList = new ArrayList<>();
        borrowList.add(borrow);
        borrowList.add(borrow1);
        borrowList.add(borrow2);

        Mockito.when(borrowRepository.findAllByBorrowedFromEquals(Mockito.any())).thenReturn(borrowList);

        Set<UserDto> userDtoSet = borrowService.retrieveUsersBorrowedOnGivenDate("11/01/2020");

        Assertions.assertEquals(2, userDtoSet.size());
    }

    @Test
    @SneakyThrows
    void retrieveBooksBorrowedByUserOnGivenDateRange() {

        User user = new User();
        user.setFirstName("ali");
        user.setLastName("can");
        user.setActive(true);

        User user1 = new User();
        user1.setFirstName("gul");
        user1.setLastName("er");
        user1.setActive(false);

        Book book = new Book();
        book.setTitle("exampleBook");

        Borrow borrow = new Borrow();
        borrow.setUser(user);
        borrow.setBook(book);
        borrow.setBorrowedTo(Timestamp.from(dateFormat.parse("12/01/2020").toInstant()));
        borrow.setBorrowedFrom(Timestamp.from(dateFormat.parse("11/01/2020").toInstant()));

        Borrow borrow1 = new Borrow();
        borrow1.setBook(book);
        borrow1.setUser(user);
        borrow1.setBorrowedTo(Timestamp.from(dateFormat.parse("12/01/2020").toInstant()));
        borrow1.setBorrowedFrom(Timestamp.from(dateFormat.parse("11/01/2020").toInstant()));

        List<Borrow> borrowList = new ArrayList<>();
        borrowList.add(borrow);
        borrowList.add(borrow1);

        Mockito.when(userService.retrieveUser(Mockito.anyString(), Mockito.anyString())).thenReturn(user);

        Mockito.when(
            borrowRepository.findAllByBorrowedFromGreaterThanAndBorrowedToLessThanAndUser(Mockito.any(), Mockito.any(),
                Mockito.any())).thenReturn(borrowList);

        Set<BookDto> bookDtoSet =
            borrowService.retrieveBooksBorrowedByUserOnGivenDateRange("ali", "can", "10/01/2020", "12/02/2020");

        Assertions.assertEquals(1, bookDtoSet.size());

    }

}