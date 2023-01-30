package com.example.sahaf.controller;

import com.example.sahaf.dto.BookStoreAddBookResponse;
import com.example.sahaf.entities.BookStore;
import com.example.sahaf.request.BookStoreAddBookRequest;
import com.example.sahaf.service.BookStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("bookStore")
public class BookStoreController {
    private final BookStoreService bookStoreService;

    @PostMapping("save")
    public ResponseEntity<BookStore> saveBookStore(@RequestBody BookStore bookStore) {
        BookStore bookStore1 = bookStoreService.saveBookStore(bookStore);
        return ResponseEntity.ok(bookStore1);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteBookStore(@PathVariable("id") int id) {
        Boolean status = bookStoreService.delete(id);
        return ResponseEntity.ok(status);
    }

    @PutMapping("update")
    public ResponseEntity<BookStore> updateBookStore(@RequestBody BookStore bookStore) {
        BookStore bookStore1 = bookStoreService.updateBookStore(bookStore);
        return ResponseEntity.ok(bookStore1);
    }

    @GetMapping("findAll")
    public ResponseEntity<List<BookStore>> findAll() {
        List<BookStore> bookStore = bookStoreService.findAll();
        return ResponseEntity.ok(bookStore);
    }

    @PutMapping("book-store-add-book")
    public ResponseEntity<BookStoreAddBookResponse> bookStoreAddBook(@RequestBody BookStoreAddBookRequest request) {
        BookStoreAddBookResponse bookStoreAddBookResponse = bookStoreService.bookStoreAddBook(request);
        return ResponseEntity.ok(bookStoreAddBookResponse);
    }
}
