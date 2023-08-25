package com.example.BookshelfVerse.dto;

import com.example.BookshelfVerse.model.Book;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

public class BookDTO
{
    int id;
    String name;

    public BookDTO(Book book)
    {
        this.id = book.getId();
        this.name = book.getName();
    }
}
