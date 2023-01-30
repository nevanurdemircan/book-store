package com.example.sahaf.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Data
public class RentABookDto {
    private int id;
    private int userId;
    private int bookId;
    private Date startDate;
    private Date endDate;


}
