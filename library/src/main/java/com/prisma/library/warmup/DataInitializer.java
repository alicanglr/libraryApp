package com.prisma.library.warmup;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.List;
import java.util.Objects;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.prisma.library.control.repository.BookRepository;
import com.prisma.library.control.repository.BorrowRepository;
import com.prisma.library.control.repository.UserRepository;
import com.prisma.library.entity.table.Book;
import com.prisma.library.entity.table.Borrow;
import com.prisma.library.entity.table.User;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final CSVReader csvReader;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final BorrowRepository borrowRepository;

    private static final String[] userHeaders = { HeaderConstants.USER_NAME,
                                                  HeaderConstants.USER_FIRST_NAME,
                                                  HeaderConstants.USER_MEMBER_SINCE,
                                                  HeaderConstants.USER_MEMBER_TILL,
                                                  HeaderConstants.USER_GENDER };

    private static final String[] bookHeaders = { HeaderConstants.BOOK_TITLE,
                                                  HeaderConstants.BOOK_AUTHOR,
                                                  HeaderConstants.BOOK_GENRE,
                                                  HeaderConstants.BOOK_PUBLISHER };

    private static final String[] borrowHeaders = { HeaderConstants.BORROW_BORROWER,
                                                    HeaderConstants.BORROW_BOOK,
                                                    HeaderConstants.BORROW_FROM,
                                                    HeaderConstants.BORROW_TO };

    @Bean
    public void initUserData() throws IOException, ParseException {

        InputStream inputStream =
            new FileInputStream(Objects.requireNonNull(this.getClass().getClassLoader().getResource("user.csv")).getFile());
        List<User> userList = csvReader.readUserCsv(inputStream, userHeaders);
        userRepository.saveAll(userList);

    }

    @Bean
    public void initBookData() throws IOException {
        InputStream inputStream =
            new FileInputStream(Objects.requireNonNull(this.getClass().getClassLoader().getResource("books.csv")).getFile());
        List<Book> bookList = csvReader.readBookCsv(inputStream, bookHeaders);
        bookRepository.saveAll(bookList);
    }

    @Bean
    public void initBorrowData() throws IOException, ParseException {
        InputStream inputStream =
            new FileInputStream(Objects.requireNonNull(this.getClass().getClassLoader().getResource("borrowed.csv")).getFile());
        List<Borrow> borrowList = csvReader.readBorrowCsv(inputStream, borrowHeaders);
        borrowRepository.saveAll(borrowList);
    }
}
