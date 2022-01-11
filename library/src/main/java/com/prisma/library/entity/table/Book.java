package com.prisma.library.entity.table;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "book")
@Getter
@Setter
@EqualsAndHashCode(exclude = "borrow")
@ToString(exclude = "borrow")
public class Book {

    @Id
    private UUID id;

    private String title;

    private String author;

    private String genre;

    private String publisher;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private Set<Borrow> borrow = new HashSet<>();
}
