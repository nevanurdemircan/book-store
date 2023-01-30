package com.example.sahaf.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class BookStoreAddBookResponse {
    private String bookStoreName;
    private String bookName;
    private String author;
}
