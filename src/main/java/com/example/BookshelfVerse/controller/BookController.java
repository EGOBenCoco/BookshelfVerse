package com.example.BookshelfVerse.controller;

import com.example.BookshelfVerse.model.Book;
import com.example.BookshelfVerse.enumModel.GenreName;
import com.example.BookshelfVerse.service.serviceImp.BookServiceImp;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookController {

    BookServiceImp bookServiceImp;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Book>> findBookById(@PathVariable int id) {
        return ResponseEntity.ok(bookServiceImp.findBookById(id));
    }

    @GetMapping("/sort")
    public Page<Book> getSortedAndFilteredProducts(
            @RequestParam(required = false) GenreName genreName,
            @RequestParam(required = false) String language,
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize) {

        Pageable pageable = PageRequest.of(page, pageSize);

        return bookServiceImp.getSortedAndFilteredBooks(genreName, language, name, pageable);
    }

    @GetMapping("/all")
    public Page<Book> findAllBook(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "10") int pageSize) {
        Pageable pageable = PageRequest.of(page,pageSize);
        return bookServiceImp.findAllBook(pageable);
    }


    @PostMapping("/create")
    public ResponseEntity<String> createBook(@RequestBody Book book) {
        bookServiceImp.createBook(book);
        return ResponseEntity.ok("Create");
    }


    @PutMapping("/update")
    public ResponseEntity<String> updateBook(@RequestBody Book book) {
        bookServiceImp.updateBook(book);
        return ResponseEntity.ok("Update");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable int id) {
        bookServiceImp.deleteBookById(id);
        return ResponseEntity.ok("Delete");
    }


}

