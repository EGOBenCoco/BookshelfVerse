package com.example.BookshelfVerse.repository;

import com.example.BookshelfVerse.model.Reviews;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.List;

@Repository
public interface ReviewsRepository  extends JpaRepository<Reviews,Integer>
{
    @EntityGraph(attributePaths = "customer")
    List<Reviews> findAllByBooks_Id(int bookId);
/*@Query("SELECT AVG(r.rating) FROM Reviews r JOIN r.books b WHERE b.id = :bookId")
Double findAverageRatingByBookId(@Param("bookId") Long bookId);

    @Query("SELECT COUNT(DISTINCT r.customer.id) FROM Reviews r JOIN r.books b WHERE b.id = :bookId")
    Long findNumberOfVotersByBookId(@Param("bookId") Long bookId);*/
}
