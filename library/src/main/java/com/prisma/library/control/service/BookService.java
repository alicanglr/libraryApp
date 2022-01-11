package com.prisma.library.control.service;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.prisma.library.control.repository.BookRepository;
import com.prisma.library.entity.table.Book;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    @Transactional
    Set<Book> retrieveAllBook() {
        return new HashSet<>(bookRepository.findAll());
    }
}
