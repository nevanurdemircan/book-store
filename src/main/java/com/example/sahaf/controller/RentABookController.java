package com.example.sahaf.controller;

import com.example.sahaf.dto.FindAllByStartDateResponse;
import com.example.sahaf.dto.RentABookDto;
import com.example.sahaf.dto.UserRentedBookInformationResponse;
import com.example.sahaf.service.RentABookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("rent-book")
public class RentABookController {
    private final RentABookService rentABookService;

    @PostMapping("rent")
    public ResponseEntity<String> rentedBook(@RequestBody RentABookDto rentABookDto) {
        return ResponseEntity.ok(rentABookService.rentedBook(rentABookDto));
    }

    @GetMapping("all")
    public ResponseEntity<List<RentABookDto>> findAll() {
        return ResponseEntity.ok(rentABookService.findAll());
    }


    @GetMapping("all-by-start-date")
    public ResponseEntity<FindAllByStartDateResponse> findAllByStartDate(@RequestParam String date) throws Exception {
        return ResponseEntity.ok(rentABookService.findAllByStartDate(date));
    }

    @GetMapping("all-by-user-name")
    public ResponseEntity<UserRentedBookInformationResponse> findAlByUserName(@RequestParam String userName) {
        return ResponseEntity.ok(rentABookService.usersRentedBookInformation(userName));
    }

}
