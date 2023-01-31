package com.example.sahaf.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RentABookDto {
    private int id;
    private String bookName;
    private Date startDate;
    private Date endDate;
    private String bookStoreName;
    private String userName;
    private int bookId;

    private int userId;




}
