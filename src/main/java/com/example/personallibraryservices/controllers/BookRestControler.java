package com.example.personallibraryservices.controllers;//package com.example.personallibraryservices;
import com.example.personallibraryservices.entities.Book;
import com.example.personallibraryservices.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.util.List;
import java.net.URI;

@RestController
@RequestMapping("/books")
public class BookRestControler {
    private final  BookService service;

    public BookRestControler(BookService service){
        this.service = service;
    }

    @GetMapping
    public List<Book> getBooks(){
        return service.getAllBooks();
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id){
        return ResponseEntity.of(service.findBookByID(id));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book){
        return service.findBookByID(id)
                .map(b -> {
                    b.setTitle(book.getTitle());
                    b.setAuthor(book.getAuthor());
                    b.setIsbn(book.getIsbn());
                    b.setLocalDate(book.getLocalDate());
                    return ResponseEntity.ok(service.saveBook(b));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("new/{id}")
    public ResponseEntity<Book> newBook(@PathVariable Long id, @RequestBody Book book){

        service.saveBook(book);
        book.setId(id);
        return ResponseEntity.ok(book);
    }

    @GetMapping("/three")
    public String three() {
        service.addThreeBooks();
        return "You've added 3 books!";
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        return service.findBookByID(id)
                .map(b -> {
                    service.deleteBook(b);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllBooks() {
        service.deleteAllBooks();
        return ResponseEntity.noContent().build();
    }

}
