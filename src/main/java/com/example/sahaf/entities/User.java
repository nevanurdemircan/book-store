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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String name;
    public String surname;
    public String phoneNumber;

    @ManyToMany
    private List<BookStore> bookStores;

    @OneToMany(mappedBy = "user")
    List<RentABook> rentABooks;


}
