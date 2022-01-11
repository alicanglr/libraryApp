package com.prisma.library.boundary;

import java.text.ParseException;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prisma.library.control.service.BookService;
import com.prisma.library.control.service.BorrowService;
import com.prisma.library.control.service.UserService;
import com.prisma.library.entity.dto.BookDto;
import com.prisma.library.entity.dto.UserDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class LibraryController {

    private final BookService bookService;
    private final BorrowService borrowService;
    private final UserService userService;

    @GetMapping("/userWithAtLeastOneBorrow")
    public ResponseEntity retrieveUsersWhomBorrowedAtLeastOne() {
        Set<UserDto> userDtoSet = borrowService.retrieveUsersBorrowAtLeastOne();

        if (userDtoSet.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(userDtoSet);
    }

    @GetMapping("/activeUsersWithNoBorrowing")
    public ResponseEntity retrieveActiveUsersWithNoBorrowingCurrently() {
        Set<UserDto> userDtoSet = borrowService.retrieveActiveUsersHasNoBorrowingCurrently();

        if (userDtoSet.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(userDtoSet);
    }

    @GetMapping("/usersBorrowedOnGivenDate")
    public ResponseEntity retrieveUsersBorrowedOnGivenDate(@RequestParam("date") String givenDate) {

        Set<UserDto> userDtoSet;
        try {
            userDtoSet = borrowService.retrieveUsersBorrowedOnGivenDate(givenDate);
        } catch (ParseException parseException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Given date should be MM/dd/yyyy");
        }
        if (userDtoSet.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(userDtoSet);
    }

    @GetMapping("/booksBorrowedByUserGivenRange")
    public ResponseEntity retrieveBooksBorrowedByUserOnGivenDateRange(@RequestParam("startDate") String startDate,
        @RequestParam("endDate") String endDate, @RequestParam("firstName") String firstName,
        @RequestParam("lastName") String lastName) {

        Set<BookDto> bookDtoSet;
        try {
            bookDtoSet =
                borrowService.retrieveBooksBorrowedByUserOnGivenDateRange(firstName, lastName, startDate, endDate);
        } catch (ParseException parseException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Given date should be MM/dd/yyyy");
        }
        if (bookDtoSet.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(bookDtoSet);
    }

    @GetMapping("/availableBooks")
    public ResponseEntity retrieveAvailableBooks() {

        Set<BookDto> bookDtoSet = borrowService.retrieveAvailableBooks();

        if (bookDtoSet.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(bookDtoSet);
    }

}
