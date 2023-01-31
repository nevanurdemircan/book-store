package com.example.sahaf.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserRentedBookInformationResponse {
    private int count;
    private List<UserRentedBookInformationDto>userRentedBookInformationDtos;

}
