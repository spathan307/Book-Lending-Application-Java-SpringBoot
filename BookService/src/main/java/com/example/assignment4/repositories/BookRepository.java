package com.example.assignment4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.assignment4.models.BookModel;


@Repository
public interface BookRepository extends JpaRepository<BookModel, Integer> {

}

