package com.example.BookshelfVerse.model;

import com.example.BookshelfVerse.enumModel.GenreName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    String description;

    String title;

    String language;

    int countPage;

    @Transient
    Double averageRating;

    @Enumerated(EnumType.STRING)
    GenreName genreName;

    @ManyToMany(mappedBy = "books",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Reviews> reviews;


    @PostLoad
    public void calculateAverageRating() {
        this.averageRating = this.getReviews().stream().mapToInt(Reviews::getRating).average().orElse(0.0);
    }

    @PreUpdate
    public void onUpdate() {
        calculateAverageRating();
    }

}

