package com.example.sahaf.service;

import com.example.sahaf.dto.FindAllByStartDateResponse;
import com.example.sahaf.dto.RentABookDto;
import com.example.sahaf.entities.RentABook;

import java.util.List;


public interface RentABookService {

    String rentedBook(RentABookDto rentABookDto);

    RentABook save(RentABook rentABook);


    RentABook update(RentABook rentABook);

    List<RentABook> findAll();

    FindAllByStartDateResponse findAllByStartDate(String startDate) throws Exception;

}
