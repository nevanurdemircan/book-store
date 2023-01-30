package com.example.sahaf.controller;

import com.example.sahaf.entities.Book;
import com.example.sahaf.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("book")
public class BookController {

    private final BookService bookService;

    @PostMapping("save")
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        Book response = bookService.save(book);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteBook(@PathVariable("id") int id) {
        Boolean status = bookService.delete(id);
        return ResponseEntity.ok(status);
    }

    @PutMapping("update")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        Book book1 = bookService.updateBook(book);
        return ResponseEntity.ok(book1);
    }

    @GetMapping("findAll")
    public ResponseEntity<List<Book>> findAll() {
        List<Book> books = bookService.findAll();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Book> findById(@PathVariable int id) {
        Book book = bookService.findById(id);
        return ResponseEntity.ok(book);
    }
}

