package com.backend.booklibrary.service;

import com.backend.booklibrary.dto.BookFilterDTO;
import com.backend.booklibrary.model.Book;
import com.backend.booklibrary.repository.BookRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImplementation implements BookService{

    private final BookRepository bookRepository;
    private final EntityManager em;

    public BookServiceImplementation(BookRepository bookRepository, EntityManager em){
        this.bookRepository = bookRepository;
        this.em = em;
    }

    @Override
    public List<Book> findBooks(BookFilterDTO filterDTO) {

        CriteriaBuilder cBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Book> cQuery = cBuilder.createQuery(Book.class);
        Root<Book> root = cQuery.from(Book.class);

        Predicate predicate = cBuilder.conjunction();

        if(filterDTO.getTitle() != null){
            predicate = cBuilder.and(predicate, cBuilder
                    .like(root.get("title") ,"%" + filterDTO.getTitle() + "%"));
        }
        if(filterDTO.getAuthor() != null){
            predicate = cBuilder.and(predicate, cBuilder
                    .like(root.get("author") ,"%" + filterDTO.getAuthor() + "%"));
        }
        if(filterDTO.getMinYear() != null && filterDTO.getMaxYear() != null){
            predicate = cBuilder.and(predicate, cBuilder
                    .between(root.get("release_year"), filterDTO.getMinYear(), filterDTO.getMaxYear()));
        }
        if(filterDTO.getMinRating() != null && filterDTO.getMaxRating() != null){
            predicate = cBuilder.and(predicate, cBuilder
                    .between(root.get("averageRating"), filterDTO.getMinRating(), filterDTO.getMaxRating()));
        }
        if(filterDTO.getMinUserRating() != null && filterDTO.getMaxUserRating() != null){
            predicate = cBuilder.and(predicate, cBuilder
                    .between(root.get("userRating"), filterDTO.getMinUserRating(), filterDTO.getMaxUserRating()));

        }

        cQuery.where(predicate);
        TypedQuery<Book> query = em.createQuery(cQuery);
        return query.getResultList();
    }

    @Override
    public ResponseEntity<String> setUserRating(int id, int userRating) {
        Optional<Book> requestBook = bookRepository.findById(id);
        if(requestBook.isPresent()){
            requestBook.get().setUserRating(userRating);
            bookRepository.save(requestBook.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No such book was found.");
        }

    }


}
