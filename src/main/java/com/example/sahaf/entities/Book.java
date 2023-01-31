package com.example.sahaf.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String authorName;
    private String publisher;

    @ManyToOne
    @JoinColumn(name = "book_store_id")
    private BookStore bookStore;

    @OneToMany(mappedBy = "book")
    private List<RentABook> rentABooks;
}
