package com.example.BookshelfVerse.dto;

import com.example.BookshelfVerse.model.Customer;
import com.example.BookshelfVerse.model.Reviews;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReviewsDTO
{
    int id;

    String reviewText;

    int rating;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;


    CustomerDTO customerDTO;

    public ReviewsDTO(Reviews reviews)
    {
        this.id = reviews.getId();
        this.createdAt = reviews.getCreatedAt();
        this.updatedAt = reviews.getUpdatedAt();
        this.rating = reviews.getRating();
        this.customerDTO = new CustomerDTO(reviews.getCustomer());
    }
}
