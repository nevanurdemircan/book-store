package com.example.sahaf.service;

import com.example.sahaf.dto.FindAllByStartDateResponse;
import com.example.sahaf.dto.RentABookDto;
import com.example.sahaf.dto.UserRentedBookInformationResponse;

import java.util.List;


public interface RentABookService {

    String rentedBook(RentABookDto rentABookDto);

    List<RentABookDto> findAll();

    FindAllByStartDateResponse findAllByStartDate(String startDate) throws Exception;

    UserRentedBookInformationResponse usersRentedBookInformation(String userName);

}
