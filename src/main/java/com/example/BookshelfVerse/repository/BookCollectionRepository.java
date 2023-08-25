package com.example.BookshelfVerse.repository;

import com.example.BookshelfVerse.model.Book;
import com.example.BookshelfVerse.model.BookCollection;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookCollectionRepository extends JpaRepository<BookCollection,Integer> {


    @EntityGraph(attributePaths = "bookList")
    @Query("SELECT bc FROM BookCollection bc  WHERE bc.customer.id = :id")
    List<BookCollection> findBookCollectionByCustomerId(@Param("id") int id);
    @EntityGraph(attributePaths = "bookList")
    @Query("SELECT bc FROM BookCollection bc  WHERE bc.customer.id = :id")
    BookCollection findById(int id);
    @EntityGraph(attributePaths = "bookList")
    @Query("SELECT bc FROM BookCollection bc  WHERE bc.collectionStatus = :status")
    List<BookCollection> findBookCollectionByCollectionStatus(@Param("status")String status);
}
