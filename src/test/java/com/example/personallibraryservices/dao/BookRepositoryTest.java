package com.example.personallibraryservices.dao;
import com.example.personallibraryservices.entities.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository repository;

    Book[] books = {new Book("Jade City", "Fonda Lee", "123abc", "1/1/2023", 1L),
            new Book("The Poppy War", "R.F. Kuang", "456def", "2/14/2023", 2L),
            new Book("The City Of Brass", "S.A. Chakraborty", "678ghi","10/29/2023", 3L)};
    private final List<Book> booksList = new ArrayList<Book>(Arrays.asList(books)
    );

    @Test
    void countBooks(){
        repository.saveAll(booksList);
        assertEquals(3, repository.count());
    }
}
