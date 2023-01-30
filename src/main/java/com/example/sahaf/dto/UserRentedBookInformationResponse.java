package com.example.sahaf.dto;

import com.example.sahaf.entities.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserRentedBookInformationResponse {
    private int count;
    List<UserRentedBookInformationDto>userRentedBookInformationDtos;

}
