package com.prisma.library.control.service;

import org.springframework.stereotype.Service;

import com.prisma.library.control.repository.UserRepository;
import com.prisma.library.entity.table.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User retrieveUser(String firstName, String lastName) {
        return userRepository.findByFirstNameAndLastName(firstName, lastName).get();
    }
}
