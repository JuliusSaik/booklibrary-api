package com.backend.booklibrary.dto;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;



@Getter
@Setter
public class BookFilterDTO {

    private String title;
    private String author;

    @Nullable
    private Integer minYear;
    private Integer maxYear;
    private Double minRating;
    private Double maxRating;
    private Integer minUserRating;
    private Integer maxUserRating;


}