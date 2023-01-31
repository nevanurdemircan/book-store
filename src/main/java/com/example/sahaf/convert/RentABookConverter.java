package com.example.sahaf.convert;

import com.example.sahaf.dto.RentABookDto;
import com.example.sahaf.dto.UserRentedBookInformationDto;
import com.example.sahaf.entities.RentABook;
import org.springframework.stereotype.Component;

@Component
public class RentABookConverter {
    public RentABookDto rentABookConvertToRentABookDto(RentABook rentABook) {
        RentABookDto dto = new RentABookDto();

        dto.setBookName(rentABook.getBookName());
        dto.setStartDate(rentABook.getStartDate());
        dto.setEndDate(rentABook.getEndDate());
        dto.setBookStoreName(rentABook.getBookStoreName());
        dto.setId(rentABook.getId());
        dto.setUserName(rentABook.getBookName());

        return dto;

    }
    public RentABook rentABookDtoConvertToRentABook(RentABookDto rentABookDto){
        RentABook rentABook = new RentABook();
        rentABook.setBookName(rentABook.getBookName());
        rentABook.setStartDate(rentABook.getStartDate());
        rentABook.setEndDate(rentABook.getEndDate());
        rentABook.setBookStoreName(rentABook.getBookStoreName());
        rentABook.setId(rentABook.getId());

        return rentABook;

    }
    public UserRentedBookInformationDto rentABookDtoConvertToUserRentedBookInformationDto(RentABook rentABook){
        UserRentedBookInformationDto dto = new UserRentedBookInformationDto();
        dto.setBookName(rentABook.getBook().getName());
        dto.setBookStoreName(rentABook.getBook().getBookStore().getName());

        return dto;
    }
}
