package com.prisma.library.control.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prisma.library.entity.table.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByFirstNameAndLastName(String firstName, String lastName);

}
