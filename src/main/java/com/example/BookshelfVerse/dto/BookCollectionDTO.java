package com.example.BookshelfVerse.dto;

import com.example.BookshelfVerse.model.BookCollection;
import com.example.BookshelfVerse.enumModel.CollectionStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookCollectionDTO {
    int id;
    LocalDateTime updatedAt;
    LocalDateTime createdAt;
    CollectionStatus collectionStatus;
    List<BookDTO> bookDTOList;

    public BookCollectionDTO(BookCollection bookCollection)
    {
        this.id = bookCollection.getId();
        this.createdAt = bookCollection.getCreatedAt();
        this.updatedAt = bookCollection.getUpdatedAt();
        this.collectionStatus = bookCollection.getCollectionStatus();
        this.bookDTOList = bookCollection.getBookList().stream().map(BookDTO::new).toList();
    }
}
