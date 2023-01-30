package com.example.sahaf.service.impl;

import com.example.sahaf.entities.Book;
import com.example.sahaf.repository.BookRepository;
import com.example.sahaf.service.BookService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return this.bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book updateBook(Book book) {
        return this.bookRepository.save(book);
    }

    @Override
    public Boolean delete(int id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            bookRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Book findById(int id) {
        return this.bookRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }


}
