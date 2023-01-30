package com.example.sahaf.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class BookCreateDto {

    public int id;
    public String name;
    public String authorName;
    public String publisher;
}
