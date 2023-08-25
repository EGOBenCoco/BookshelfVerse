package com.example.BookshelfVerse.controller;

import com.example.BookshelfVerse.model.BookCollection;
import com.example.BookshelfVerse.model.BookMarks;
import com.example.BookshelfVerse.service.serviceImp.BookMarksServiceImp;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mark")
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class BookMarksController
{
    BookMarksServiceImp bookMarksServiceImp;

    @GetMapping("collection/{id}")
    public ResponseEntity<List<BookMarks>> findBookMarksByBookCollectionId(@PathVariable int id)
    {
        return ResponseEntity.ok(bookMarksServiceImp.findBookMarksByBookCollectionId(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<BookMarks>> findBookMarksById(@PathVariable int id)
    {
        return ResponseEntity.ok(bookMarksServiceImp.findById(id));
    }

    @PutMapping("update")
    public ResponseEntity<String> updateBookMarks(@RequestBody BookMarks bookMarks)
    {
        bookMarksServiceImp.updateBookMarks(bookMarks);
        return ResponseEntity.ok("Update");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBookMarksById(@PathVariable int id)
    {
        bookMarksServiceImp.deleteBookMarksById(id);
        return ResponseEntity.ok("Delete");
    }


}
