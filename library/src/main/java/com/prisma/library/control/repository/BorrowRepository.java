package com.prisma.library.control.repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prisma.library.entity.table.Borrow;
import com.prisma.library.entity.table.User;

public interface BorrowRepository extends JpaRepository<Borrow, UUID> {

    List<Borrow> findAllByBorrowedToLessThan(Timestamp timestamp);

    List<Borrow> findAllByBorrowedToGreaterThan(Timestamp timestamp);

    List<Borrow> findAllByBorrowedFromEquals(Timestamp timestamp);

    List<Borrow> findAllByBorrowedFromGreaterThanAndBorrowedToLessThanAndUser(Timestamp startDate, Timestamp endDate,
        User user);

}
