package com.prisma.library.control.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.prisma.library.entity.dto.UserDto;
import com.prisma.library.entity.table.User;

@Mapper
public interface UserMapper {

    static UserMapper getInstance() {
        return Mappers.getMapper(UserMapper.class);
    }

    UserDto userToUserDto(User user);
}
