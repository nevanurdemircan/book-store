package com.example.sahaf.service.impl;

import com.example.sahaf.convert.BookConverter;
import com.example.sahaf.dto.BookDto;
import com.example.sahaf.entities.Book;
import com.example.sahaf.repository.BookRepository;
import com.example.sahaf.service.BookService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookConverter bookConverter;
    @Override
    public BookDto save(BookDto bookDto) {
        Book book = bookConverter.bookDtoConvertToBook(bookDto);
        book = bookRepository.save(book);
        return bookConverter.bookConvertToBookDto(book);
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream().map(bookConverter::bookConvertToBookDto).collect(Collectors.toList());
    }

    @Override
    public BookDto updateBook(BookDto bookDto) {
        Book book = bookConverter.bookDtoConvertToBook(bookDto);
        book = bookRepository.save(book);
        return bookConverter.bookConvertToBookDto(book);
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
    public BookDto findById(int id) {
        Book book = bookRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        BookDto bookDto = new BookDto();
        bookDto.setPublisher(book.getPublisher());
        bookDto.setName(book.getName());
        bookDto.setAuthorName(book.getAuthorName());
        return bookDto;
    }
}
