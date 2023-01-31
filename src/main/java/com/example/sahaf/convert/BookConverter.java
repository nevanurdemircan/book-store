package com.example.sahaf.convert;

import com.example.sahaf.dto.BookDto;
import com.example.sahaf.entities.Book;
import org.springframework.stereotype.Component;

@Component
public class BookConverter {
    public BookDto bookConvertToBookDto(Book book){
        BookDto dto = new BookDto();
        dto.setAuthorName(book.getAuthorName());
        dto.setName(book.getName());
        dto.setPublisher(book.getPublisher());
        return dto;
    }
    public Book bookDtoConvertToBook(BookDto bookDto){
        Book book = new Book();
        book.setName(book.getName());
        book.setPublisher(book.getPublisher());
        book.setAuthorName(book.getAuthorName());
        book.setBookStore(book.getBookStore());
        book.setRentABooks(book.getRentABooks());
        book.setId(book.getId());
        return book;
    }
}
