package com.example.sahaf.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookCreateDto {

    private int id;
    private String name;
    private String authorName;
    private String publisher;
}
