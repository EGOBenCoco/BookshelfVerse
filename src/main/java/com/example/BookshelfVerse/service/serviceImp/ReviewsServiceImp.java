package com.example.BookshelfVerse.service.serviceImp;

import com.example.BookshelfVerse.dto.ReviewsDTO;
import com.example.BookshelfVerse.model.Reviews;
import com.example.BookshelfVerse.repository.ReviewsRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ReviewsServiceImp {
    ReviewsRepository reviewsRepository;


    public ReviewsDTO findById(int id) {
        Reviews reviews = reviewsRepository.findById(id).orElseThrow();
        return new ReviewsDTO(reviews);
    }

    public List<ReviewsDTO> findReviewsByBookId(int id)
    {
        List<Reviews> reviews = reviewsRepository.findAllByBooks_Id(id);
        return reviews.stream().map(ReviewsDTO::new).toList();
    }

    public void createReviews(Reviews reviews) {
        reviewsRepository.save(reviews);
    }


    public void updateReviews(Reviews reviews) {
        reviewsRepository.save(reviews);
    }

    public void deleteReviewsById(int id) {
        reviewsRepository.deleteById(id);
    }
}
