package com.prisma.library.control.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.prisma.library.entity.dto.BookDto;
import com.prisma.library.entity.table.Book;

@Mapper
public interface BookMapper {

    static BookMapper getInstance() {
        return Mappers.getMapper(BookMapper.class);
    }

    BookDto bookToBookDto(Book book);
}
