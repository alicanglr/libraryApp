package com.prisma.library.entity.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class BookDto implements Serializable {

    private String title;

    private String author;

    private String genre;

    private String publisher;
}
