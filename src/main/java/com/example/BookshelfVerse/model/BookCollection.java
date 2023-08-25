package com.example.BookshelfVerse.model;

import com.example.BookshelfVerse.enumModel.CollectionStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookCollection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
   // String description;

   // int countBook;

    @Enumerated(EnumType.STRING)
    CollectionStatus collectionStatus;

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
    @JoinTable(name = "collection_books",
            joinColumns = @JoinColumn(name = "bookCollection_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    List<Book> bookList;

    @OneToMany(mappedBy = "bookCollection",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    List<BookMarks> bookMarks;


}
