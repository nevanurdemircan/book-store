package com.example.sahaf.service;

import com.example.sahaf.entities.Book;


import java.util.List;

public interface BookService {
    Book save(Book book);

    List<Book> findAll();

    Book updateBook(Book book);

    Boolean delete(int id);

    Book findById(int id);
}
