package com.example.sahaf.repository;

import com.example.sahaf.entities.RentABook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;


public interface RentABookRepository extends JpaRepository<RentABook, Integer> {
    List<RentABook> findAllByStartDateLessThanEqualAndStartDateGreaterThanEqual(Date endDate, Date date);


}
