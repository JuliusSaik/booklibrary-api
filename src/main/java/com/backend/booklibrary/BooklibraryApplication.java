package com.backend.booklibrary;

import com.backend.booklibrary.model.Book;
import com.backend.booklibrary.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class BooklibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooklibraryApplication.class, args);

	}

}
