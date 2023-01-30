package com.example.sahaf.service.impl;

import com.example.sahaf.dto.BookStoreAddBookResponse;
import com.example.sahaf.entities.Book;
import com.example.sahaf.entities.BookStore;
import com.example.sahaf.repository.BookStoreRepository;
import com.example.sahaf.request.BookStoreAddBookRequest;
import com.example.sahaf.service.BookService;
import com.example.sahaf.service.BookStoreService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookStoreServiceImpl implements BookStoreService {
    private final BookStoreRepository bookStoreRepository;
    private final BookService bookService;

    @Override
    public BookStore saveBookStore(BookStore bookStore) {
        return bookStoreRepository.save(bookStore);
    }

    @Override
    public List<BookStore> findAll() {
        return bookStoreRepository.findAll();
    }

    @Override
    public BookStore updateBookStore(BookStore bookStore) {
        return bookStoreRepository.save(bookStore);
    }

    @Override
    public Boolean delete(int id) {
        Optional<BookStore> bookStore = bookStoreRepository.findById(id);
        if (bookStore.isPresent()) {
            bookStoreRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public BookStoreAddBookResponse bookStoreAddBook(BookStoreAddBookRequest request) {
        BookStore bookStore = bookStoreRepository.findById(request.getBookStoreId()).orElseThrow(EntityNotFoundException::new);
        Book book = bookService.findById(request.getBookId());

        book.setBookStore(bookStore);
        bookService.save(book);

        BookStoreAddBookResponse response = new BookStoreAddBookResponse();
        response.setBookStoreName(bookStore.getName());
        response.setBookName(book.name);
        response.setAuthor(book.getAuthorName());
        return response;
    }

}
