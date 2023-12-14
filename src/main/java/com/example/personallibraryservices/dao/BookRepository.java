package com.example.personallibraryservices.dao;

import com.example.personallibraryservices.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigDecimal;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>{

}
