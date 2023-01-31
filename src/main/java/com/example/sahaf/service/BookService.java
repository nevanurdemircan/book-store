package com.example.sahaf.service;

import com.example.sahaf.dto.BookDto;


import java.util.List;

public interface BookService {
    BookDto save(BookDto bookDto);

    List<BookDto> findAll();

    BookDto updateBook(BookDto bookDto);

    Boolean delete(int id);

    BookDto findById(int id);
}
