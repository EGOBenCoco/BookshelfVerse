package com.example.BookshelfVerse.controller;

import com.example.BookshelfVerse.dto.BookCollectionDTO;
import com.example.BookshelfVerse.model.BookCollection;
import com.example.BookshelfVerse.repository.BookCollectionRepository;
import com.example.BookshelfVerse.service.serviceImp.BookCollectionServiceImp;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/collection")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class BookCollectionController
{
    BookCollectionServiceImp bookCollectionServiceImp;

    @GetMapping("/customer/{id}")
    public ResponseEntity<List<BookCollectionDTO>> findBookCollectionByCustomerId(@PathVariable int id)
    {
        return ResponseEntity.ok(bookCollectionServiceImp.findBookCollectionByCustomerId(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookCollectionDTO> findBookCollectionById(@PathVariable int id)
    {
        return ResponseEntity.ok(bookCollectionServiceImp.findBookCollectionById(id));
    }

   /* @GetMapping("/sort/{status}")
    public ResponseEntity<List<BookCollectionDTO>> getBookCollectionByStatus(@PathVariable String status)
    {
        return ResponseEntity.ok(bookCollectionServiceImp.getBookCollectionByStatus(status));
    }
*/
    @PostMapping("/create")
    public ResponseEntity<String> createBookCollection(@RequestBody BookCollection bookCollection)
    {
        bookCollectionServiceImp.createBookCollection(bookCollection);
        return ResponseEntity.ok("Create");
    }


    @PutMapping("/update")
    public ResponseEntity<String> updateBookCollection(@RequestBody BookCollection bookCollection)
    {
        bookCollectionServiceImp.updateBookCollection(bookCollection);
        return ResponseEntity.ok("Update");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBookCollectionById(@PathVariable int id) {
        bookCollectionServiceImp.deleteBookCollection(id);
        return ResponseEntity.ok("Delete");
    }
}
