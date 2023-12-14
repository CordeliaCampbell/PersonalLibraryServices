package com.example.personallibraryservices.services;

import com.example.personallibraryservices.dao.BookRepository;
import com.example.personallibraryservices.entities.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
    public void initializeDatabase() {
        // Don't need this (initialization in src/main/resources/data.sql)
    }


    Book[] books = {new Book("Jade City", "Fonda Lee", "123abc", "1/1/2023", 1L),
            new Book("The Poppy War", "R.F. Kuang", "456def", "2/14/2023", 2L),
            new Book("The City Of Brass", "S.A. Chakraborty", "678ghi","10/29/2023", 3L)};
    private final List<Book> booksList = new ArrayList<Book>(Arrays.asList(books)
    );
    public void addThreeBooks() {
        bookRepository.saveAll(booksList);
    }
    @Transactional(readOnly = true)
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Book> findBookByID(Long id) {
        return bookRepository.findById(id);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

    public void deleteAllBooks() {
        bookRepository.deleteAllInBatch();
    }

}
