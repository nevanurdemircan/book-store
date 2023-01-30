package com.example.sahaf.service;

import com.example.sahaf.dto.BookStoreAddBookResponse;
import com.example.sahaf.entities.BookStore;
import com.example.sahaf.request.BookStoreAddBookRequest;

import java.util.List;

public interface BookStoreService {
    BookStore saveBookStore(BookStore bookStore);

    List<BookStore> findAll();

    BookStore updateBookStore(BookStore bookStore);

    Boolean delete(int id);

    BookStoreAddBookResponse bookStoreAddBook(BookStoreAddBookRequest request);

}
