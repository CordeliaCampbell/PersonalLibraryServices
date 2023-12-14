package com.example.personallibraryservices.controllers;
import com.example.personallibraryservices.dao.BookRepository;
import com.example.personallibraryservices.entities.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings({"SqlNoDataSourceInspection", "SqlResolve"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

 class BookRestControllerFunctionalTest {
    @Autowired
    private WebTestClient client;

    @Autowired
    private BookRepository repo;

    private List<Long> ids;


    Book[] books = {new Book("Jade City", "Fonda Lee", "123abc", "1/1/2023", 1L),
            new Book("The Poppy War", "R.F. Kuang", "456def", "2/14/2023", 2L),
            new Book("The City Of Brass", "S.A. Chakraborty", "678ghi","10/29/2023", 3L)};
    private final List<Book> booksList = new ArrayList<Book>(Arrays.asList(books)
    );




    @BeforeEach
    void setUp(){
        repo.deleteAll();
        repo.saveAll(booksList);
        ids = repo.findAll().stream().map(Book::getId).toList();

    }

    @Test
    void getAllBooks(){
        client.get().uri("/books")
                .exchange().expectStatus().isOk()
                .expectBodyList(Book.class)
                .consumeWith(response -> assertThat(response.getResponseBody())
                .hasSize(3)
                .containsAll(booksList));
    }

}
