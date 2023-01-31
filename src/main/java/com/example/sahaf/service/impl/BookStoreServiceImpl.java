package com.example.sahaf.service.impl;

import com.example.sahaf.convert.BookStoreConverter;
import com.example.sahaf.dto.BookDto;
import com.example.sahaf.dto.BookStoreAddBookResponse;
import com.example.sahaf.dto.BookStoreDto;
import com.example.sahaf.entities.BookStore;
import com.example.sahaf.repository.BookStoreRepository;
import com.example.sahaf.request.BookStoreAddBookRequest;
import com.example.sahaf.service.BookService;
import com.example.sahaf.service.BookStoreService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookStoreServiceImpl implements BookStoreService {
    private final BookStoreRepository bookStoreRepository;
    private final BookService bookService;
    private final BookStoreConverter bookStoreConverter;


    @Override
    public BookStoreDto save(BookStoreDto bookStoreDto) {
        BookStore bookStore = bookStoreConverter.bookStoreDtoConvertToBookStore(bookStoreDto);
        bookStore=bookStoreRepository.save(bookStore);
        return bookStoreConverter.bookStoreConvertToBookStoreDto(bookStore);
    }

    @Override
    public List<BookStoreDto> findAll() {
        return bookStoreRepository.findAll().stream().map(bookStoreConverter::bookStoreConvertToBookStoreDto).collect(Collectors.toList());
    }

    @Override
    public BookStoreDto updateBookStore(BookStoreDto bookStoreDto) {
        BookStore bookStore = bookStoreConverter.bookStoreDtoConvertToBookStore(bookStoreDto);
        bookStore=bookStoreRepository.save(bookStore);
        return bookStoreConverter.bookStoreConvertToBookStoreDto(bookStore);
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
        BookDto bookDto = bookService.findById(request.getBookId());

        bookDto.setBookStore(bookDto.getBookStore());
        bookService.save(bookDto);
        BookStoreAddBookResponse response = new BookStoreAddBookResponse();
        response.setBookStoreName(bookStore.getName());
        response.setBookName(bookDto.getName());
        response.setAuthor(bookDto.getAuthorName());
        return response;
    }

}
