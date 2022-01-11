package com.prisma.library.entity.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class UserDto implements Serializable {

    private String lastName;

    private String firstName;

    private Timestamp memberSince;

    private Timestamp memberTill;

    private String gender;

}
