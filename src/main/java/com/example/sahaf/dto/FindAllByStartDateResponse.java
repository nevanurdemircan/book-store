package com.example.sahaf.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class FindAllByStartDateResponse {
    private List<RentABookDto>rentABookDtoList;
    private int count;

}
