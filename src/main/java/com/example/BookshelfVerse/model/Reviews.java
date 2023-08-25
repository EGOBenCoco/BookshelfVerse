package com.example.BookshelfVerse.model;

        import lombok.AccessLevel;
        import lombok.Getter;
        import lombok.Setter;
        import lombok.experimental.FieldDefaults;
        import org.hibernate.annotations.CreationTimestamp;
        import org.hibernate.annotations.UpdateTimestamp;

        import javax.persistence.*;
        import java.time.LocalDateTime;
        import java.util.List;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String reviewText;

    int rating;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    LocalDateTime updatedAt;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    Customer customer;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "reviews_books",
            joinColumns = @JoinColumn(name = "reviews_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    List<Book> books;


}
