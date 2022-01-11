package com.prisma.library.entity.table;

import java.sql.Timestamp;
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
@Table(name = "user")
@Getter
@Setter
@EqualsAndHashCode(exclude = "borrow")
@ToString(exclude = "borrow")
public class User {

    @Id
    private UUID id;

    private String lastName;

    private String firstName;

    private Timestamp memberSince;

    private Timestamp memberTill;

    private String gender;

    private Boolean active;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Borrow> borrow;
}
