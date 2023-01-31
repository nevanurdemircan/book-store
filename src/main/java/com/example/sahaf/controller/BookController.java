package com.example.sahaf.controller;

import com.example.sahaf.dto.BookDto;
import com.example.sahaf.service.BookService;
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
@RequestMapping("book")
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookDto> save(@RequestBody BookDto bookDto) {
        return ResponseEntity.ok(bookService.save(bookDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        return ResponseEntity.ok(bookService.delete(id));
    }

    @PutMapping
    public ResponseEntity<BookDto> update(@RequestBody BookDto bookDto) {
        return ResponseEntity.ok(bookService.updateBook(bookDto));
    }

    @GetMapping("all")
    public ResponseEntity<List<BookDto>> findAll() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<BookDto> findById(@PathVariable int id) {
        return ResponseEntity.ok(bookService.findById(id));
    }
}

