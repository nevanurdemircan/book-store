package com.example.sahaf.controller;

import com.example.sahaf.dto.FindAllByStartDateResponse;
import com.example.sahaf.dto.RentABookDto;
import com.example.sahaf.entities.RentABook;
import com.example.sahaf.service.RentABookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("rentABook")
public class RentABookController {
    private final RentABookService rentABookService;

    @PostMapping("rent")
    public ResponseEntity<String> rentedBook(@RequestBody RentABookDto rentABookDto) {
        String string = rentABookService.rentedBook(rentABookDto);
        return ResponseEntity.ok(string);
    }

    @GetMapping("findAll")
    public ResponseEntity<List<RentABook>> findAll() {
        List<RentABook> rentABooks = rentABookService.findAll();
        return ResponseEntity.ok(rentABooks);
    }


    @GetMapping("findAllByStartDate")
    public ResponseEntity<FindAllByStartDateResponse> findAllByStartDate(@RequestParam String date) throws Exception {

        FindAllByStartDateResponse rentABook = rentABookService.findAllByStartDate(date);
        return ResponseEntity.ok(rentABook);
    }
}
