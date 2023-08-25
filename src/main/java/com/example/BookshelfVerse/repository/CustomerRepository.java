package com.example.BookshelfVerse.repository;

import com.example.BookshelfVerse.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    //@EntityGraph(attributePaths = "bookCollection.bookList")
    Page<Customer> findAll(Pageable pageable);

    // @EntityGraph(attributePaths = "bookCollections.bookList")
    //@Query("SELECT c FROM Customer c JOIN FETCH c.bookCollections WHERE c.id = :id")
    Customer findById(@Param("id") int id);
}
