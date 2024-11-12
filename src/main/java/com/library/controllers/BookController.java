package com.library.controllers;

import com.library.models.Book;
import com.library.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookServiceService;

    @GetMapping
    public List<Book> getAllLivros() {
        return bookServiceService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBooksById(@PathVariable Long id) {
        return bookServiceService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Book createBook(@Valid @RequestBody Book book) {
        return bookServiceService.save(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookServiceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

