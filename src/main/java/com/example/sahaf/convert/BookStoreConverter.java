package com.example.sahaf.convert;

import com.example.sahaf.dto.BookStoreDto;
import com.example.sahaf.entities.BookStore;
import org.springframework.stereotype.Component;

@Component
public class BookStoreConverter {
    public BookStoreDto bookStoreConvertToBookStoreDto(BookStore bookStore){
        BookStoreDto dto = new BookStoreDto();
        dto.setName(bookStore.getName());
        dto.setPhoneNumber(bookStore.getPhoneNumber());
        return dto;
    }
    public BookStore bookStoreDtoConvertToBookStore(BookStoreDto bookStoreDto){
        BookStore bookStore= new BookStore();
        bookStore.setName(bookStoreDto.getName());
        bookStore.setPhoneNumber(bookStoreDto.getPhoneNumber());
        bookStore.setId(bookStore.getId());
        return bookStore;
    }
}
