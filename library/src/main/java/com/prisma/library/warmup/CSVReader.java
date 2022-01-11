package com.prisma.library.warmup;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import com.prisma.library.control.repository.BookRepository;
import com.prisma.library.control.repository.UserRepository;
import com.prisma.library.entity.table.Book;
import com.prisma.library.entity.table.Borrow;
import com.prisma.library.entity.table.User;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CSVReader {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

    public List<User> readUserCsv(InputStream inputStream, String[] headers) throws IOException, ParseException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        List<CSVRecord> csvRecords = getCsvRecords(inputStreamReader, headers);

        List<User> users = new ArrayList<>();

        for (CSVRecord csvRecord : csvRecords) {

            User user = new User();
            user.setId(UUID.randomUUID());

            String lastName = csvRecord.get(HeaderConstants.USER_NAME);
            user.setLastName(lastName);

            String firstName = csvRecord.get(HeaderConstants.USER_FIRST_NAME);
            user.setFirstName(firstName);

            String memberSince = csvRecord.get(HeaderConstants.USER_MEMBER_SINCE);
            user.setMemberSince(
                memberSince.isEmpty() ? null : Timestamp.from(dateFormat.parse(memberSince).toInstant()));

            String memberTill = csvRecord.get(HeaderConstants.USER_MEMBER_TILL);
            user.setMemberTill(memberTill.isEmpty() ? null : Timestamp.from(dateFormat.parse(memberTill).toInstant()));

            String gender = csvRecord.get(HeaderConstants.USER_GENDER);
            user.setGender(gender);

            user.setActive(memberTill.isEmpty());

            users.add(user);
        }

        return users;
    }

    public List<Book> readBookCsv(InputStream inputStream, String[] headers) throws IOException {

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        List<CSVRecord> csvRecords = getCsvRecords(inputStreamReader, headers);

        List<Book> bookList = new ArrayList<>();

        for (CSVRecord csvRecord : csvRecords) {
            Book book = new Book();
            book.setId(UUID.randomUUID());
            String author = csvRecord.get(HeaderConstants.BOOK_AUTHOR);
            String title = csvRecord.get(HeaderConstants.BOOK_TITLE);
            String genre = csvRecord.get(HeaderConstants.BOOK_GENRE);
            String publisher = csvRecord.get(HeaderConstants.BOOK_PUBLISHER);
            if (author.isEmpty() || title.isEmpty() || genre.isEmpty() || publisher.isEmpty()) {
                continue;
            }
            book.setAuthor(author);
            book.setTitle(title);
            book.setGenre(genre);
            book.setPublisher(publisher);
            bookList.add(book);
        }

        return bookList;
    }

    public List<Borrow> readBorrowCsv(InputStream inputStream, String[] headers) throws IOException, ParseException {

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        List<CSVRecord> csvRecords = getCsvRecords(inputStreamReader, headers);

        List<Borrow> borrowList = new ArrayList<>();

        for (CSVRecord csvRecord : csvRecords) {
            Borrow borrow = new Borrow();
            borrow.setId(UUID.randomUUID());

            String borrower = csvRecord.get(HeaderConstants.BORROW_BORROWER);
            User user = retrieveUser(borrower);

            String borrowedBook = csvRecord.get(HeaderConstants.BORROW_BOOK);
            Book book = retrieveBook(borrowedBook);

            borrow.setUser(user);
            borrow.setBook(book);

            String borrowedFrom = csvRecord.get(HeaderConstants.BORROW_FROM);
            borrow.setBorrowedFrom(Timestamp.from(dateFormat.parse(borrowedFrom).toInstant()));

            String borrowedTo = csvRecord.get(HeaderConstants.BORROW_TO);
            borrow.setBorrowedTo(Timestamp.from(dateFormat.parse(borrowedTo).toInstant()));

            borrowList.add(borrow);

        }
        return borrowList;
    }

    private List<CSVRecord> getCsvRecords(InputStreamReader inputStreamReader, String[] headers) throws IOException {

        return CSVFormat.DEFAULT.withHeader(headers)
            .withSkipHeaderRecord()
            .withDelimiter(',')
            .withAllowMissingColumnNames()
            .withIgnoreHeaderCase()
            .parse(inputStreamReader)
            .getRecords();
    }

    private Book retrieveBook(String borrowedBook) {

        return bookRepository.findByTitle(borrowedBook).get();
    }

    private User retrieveUser(String borrower) {
        String lastName = borrower.split(",")[0];
        String firstName = borrower.split(",")[1];
        return userRepository.findByFirstNameAndLastName(firstName, lastName).get();
    }

}
