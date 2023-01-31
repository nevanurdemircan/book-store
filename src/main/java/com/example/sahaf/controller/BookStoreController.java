package com.example.sahaf.controller;

import com.example.sahaf.dto.BookStoreAddBookResponse;
import com.example.sahaf.dto.BookStoreDto;
import com.example.sahaf.request.BookStoreAddBookRequest;
import com.example.sahaf.service.BookStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("book-store")
public class BookStoreController {
    private final BookStoreService bookStoreService;
    @PostMapping
    public ResponseEntity<BookStoreDto> save(@RequestBody BookStoreDto bookStoreDto) {
        return ResponseEntity.ok(bookStoreService.save(bookStoreDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
        return ResponseEntity.ok(bookStoreService.delete(id));
    }
    @PutMapping
    public ResponseEntity<BookStoreDto> update(@RequestBody BookStoreDto bookStoreDto) {
        return ResponseEntity.ok(bookStoreService.updateBookStore(bookStoreDto));
    }

    @GetMapping("all")
    public ResponseEntity<List<BookStoreDto>> findAll() {
        return ResponseEntity.ok(bookStoreService.findAll());
    }

    @PutMapping("add-book")
    public ResponseEntity<BookStoreAddBookResponse> addBook(@RequestBody BookStoreAddBookRequest request) {
        return ResponseEntity.ok(bookStoreService.bookStoreAddBook(request));
    }
}
