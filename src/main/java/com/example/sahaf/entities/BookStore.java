package com.example.sahaf.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookStore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String phoneNumber;

    @OneToMany(mappedBy = "bookStore")
    private List<Book> books;

    @ManyToMany(mappedBy = "bookStores")
    private List<User> users;

}
