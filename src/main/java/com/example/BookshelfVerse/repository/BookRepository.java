package com.example.BookshelfVerse.repository;

import com.example.BookshelfVerse.model.Book;
import com.example.BookshelfVerse.enumModel.GenreName;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>
{



    @EntityGraph(attributePaths = "reviews")
    Optional<Book> findById( int id);

    @EntityGraph(attributePaths = "reviews")
    Page<Book> findAll(Pageable pageable);

    Page<Book> findBookByName(String name,Pageable pageable);
    Page<Book> findByGenreName(GenreName genreName, Pageable pageable);
    Page<Book> findAllByLanguage(String language, Pageable pageable);
}
