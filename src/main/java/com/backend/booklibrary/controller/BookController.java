package com.backend.booklibrary.controller;

import com.backend.booklibrary.dto.BookFilterDTO;
import com.backend.booklibrary.model.Book;
import com.backend.booklibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping
    public List<Book> getAllBooks(@ModelAttribute BookFilterDTO bookFilterDTO) {
        return bookService.findBooks(bookFilterDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> setUserRating(@PathVariable int id, @RequestParam int rating) {
        if(rating >= 1 && rating <= 5){
            return bookService.setUserRating(id, rating);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Rating should be between 1 and 5.");
        }

    }
}
