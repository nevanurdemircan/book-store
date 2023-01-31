package com.example.sahaf.service;

import com.example.sahaf.dto.BookStoreAddBookResponse;
import com.example.sahaf.dto.BookStoreDto;
import com.example.sahaf.request.BookStoreAddBookRequest;

import java.util.List;

public interface BookStoreService {
    BookStoreDto save(BookStoreDto bookStoreDto);

    List<BookStoreDto> findAll();

    BookStoreDto updateBookStore(BookStoreDto bookStoreDto);

    Boolean delete(int id);

    BookStoreAddBookResponse bookStoreAddBook(BookStoreAddBookRequest request);

}
