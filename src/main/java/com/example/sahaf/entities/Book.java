package com.example.sahaf.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Book {

    @Id
    public int id;
    public String name;
    public String authorName;
    public String publisher;

    @ManyToOne
    @JoinColumn(name = "book_store_id")
    private BookStore bookStore;

    @OneToMany(mappedBy = "book")
    List<RentABook> rentABooks;
}
