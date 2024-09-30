package com.backend.booklibrary.service;

import com.backend.booklibrary.dto.BookFilterDTO;
import com.backend.booklibrary.model.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {



    List<Book> findBooks(BookFilterDTO bookFilterDTO);
    ResponseEntity<String> setUserRating(int id, int userRating);


}
