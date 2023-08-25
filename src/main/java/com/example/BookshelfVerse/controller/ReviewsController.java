package com.example.BookshelfVerse.controller;

import com.example.BookshelfVerse.dto.ReviewsDTO;
import com.example.BookshelfVerse.model.Reviews;
import com.example.BookshelfVerse.service.serviceImp.ReviewsServiceImp;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequestMapping("/api/reviews")
public class ReviewsController
{
    ReviewsServiceImp reviewsServiceImp;
    @GetMapping("/{id}")
    public ResponseEntity<ReviewsDTO> findAllReviewById(@PathVariable int id)
    {
        return ResponseEntity.ok(reviewsServiceImp.findById(id));
    }
    @GetMapping("/book/{id}")
    public ResponseEntity<List<ReviewsDTO>> findAllReviewsByBookId(@PathVariable int id)
    {
        return ResponseEntity.ok(reviewsServiceImp.findReviewsByBookId(id));
    }

    @PostMapping("/create")
    public ResponseEntity<String> createReviews(@RequestBody Reviews reviews)
    {
        reviewsServiceImp.createReviews(reviews);
        return ResponseEntity.ok("Create");
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateReviews(@RequestBody Reviews reviews)
    {
        reviewsServiceImp.updateReviews(reviews);
        return ResponseEntity.ok("Update");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReviewsById(@PathVariable int id) {
        reviewsServiceImp.deleteReviewsById(id);
        return ResponseEntity.ok("Delete");
    }
}


