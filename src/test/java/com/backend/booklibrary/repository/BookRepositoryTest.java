package com.backend.booklibrary.repository;

import com.backend.booklibrary.model.Book;
import jakarta.persistence.EntityManager;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void BookRepository_Save_ReturnsBook(){


        Book book = Book.builder()
                .title("The Plague")
                .author("Albert Camu")
                .release_year(1947)
                .averageRating(3.5)
                .build();

        Book savedBook = bookRepository.save(book);

        Assertions.assertThat(savedBook).isNotNull();
    }


    @Test
    void BookRepository_FindById_ReturnsBook(){


        Book book = Book.builder()
                .title("The Plague")
                .author("Albert Camu")
                .release_year(1947)
                .averageRating(3.5)
                .build();

        bookRepository.save(book);
        Optional<Book> savedBook = bookRepository.findById(book.getId());


        Assertions.assertThat(savedBook.isPresent()).isTrue();
    }

    @Test
    void BookRepository_FindByAll_ReturnsBooks(){
        Book book1 = Book.builder()
                .title("The Plague")
                .author("Albert Camu")
                .release_year(1947)
                .averageRating(4.5)
                .build();

        Book book2 = Book.builder()
                .title("The Republic")
                .author("Plato")
                .release_year(-370)
                .averageRating(4.5)
                .build();

        List<Book> myBooks = bookRepository.findAll();
        myBooks.add(book1);
        myBooks.add(book2);
        bookRepository.saveAll(myBooks);


        List<Book> books = bookRepository.findAll();
        Assertions.assertThat(books).isEqualTo(myBooks);
    }

}
