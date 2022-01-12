package com.prisma.library.warmup;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.prisma.library.control.repository.BookRepository;
import com.prisma.library.control.repository.UserRepository;
import com.prisma.library.entity.table.Book;
import com.prisma.library.entity.table.Borrow;
import com.prisma.library.entity.table.User;

import lombok.SneakyThrows;

@ExtendWith(MockitoExtension.class)
class CSVReaderTest {

    @Mock
    UserRepository userRepository;

    @Mock
    BookRepository bookRepository;

    @InjectMocks
    private CSVReader csvReader;

    @Test
    @SneakyThrows
    void readUserCsv() {
        String[] userHeaders = { HeaderConstants.USER_NAME,
                                 HeaderConstants.USER_FIRST_NAME,
                                 HeaderConstants.USER_MEMBER_SINCE,
                                 HeaderConstants.USER_MEMBER_TILL,
                                 HeaderConstants.USER_GENDER };

        InputStream inputStream = new FileInputStream(
            Objects.requireNonNull(this.getClass().getClassLoader().getResource("user.csv")).getFile());
        List<User> userList = csvReader.readUserCsv(inputStream, userHeaders);

        Assertions.assertNotNull(userList);
        Assertions.assertEquals(11, userList.size());
    }

    @Test
    @SneakyThrows
    void readBookCsv() {
        String[] bookHeaders = { HeaderConstants.BOOK_TITLE,
                                 HeaderConstants.BOOK_AUTHOR,
                                 HeaderConstants.BOOK_GENRE,
                                 HeaderConstants.BOOK_PUBLISHER };
        InputStream inputStream = new FileInputStream(
            Objects.requireNonNull(this.getClass().getClassLoader().getResource("books.csv")).getFile());
        List<Book> bookList = csvReader.readBookCsv(inputStream, bookHeaders);

        Assertions.assertNotNull(bookList);
        Assertions.assertEquals(111, bookList.size());
    }

    @Test
    @SneakyThrows
    void readBorrowCsv() {

        User user = new User();
        user.setFirstName("ex");
        user.setLastName("ex");
        Mockito.when(userRepository.findByFirstNameAndLastName(Mockito.anyString(), Mockito.anyString()))
            .thenReturn(Optional.of(user));

        Book book = new Book();
        book.setTitle("example");
        Mockito.when(bookRepository.findByTitle(Mockito.anyString())).thenReturn(Optional.of(book));

        String[] borrowHeaders = { HeaderConstants.BORROW_BORROWER,
                                   HeaderConstants.BORROW_BOOK,
                                   HeaderConstants.BORROW_FROM,
                                   HeaderConstants.BORROW_TO };
        InputStream inputStream = new FileInputStream(
            Objects.requireNonNull(this.getClass().getClassLoader().getResource("borrowed.csv")).getFile());

        List<Borrow> borrowList = csvReader.readBorrowCsv(inputStream, borrowHeaders);

        Assertions.assertNotNull(borrowList);
        Assertions.assertEquals(118, borrowList.size());
    }
}