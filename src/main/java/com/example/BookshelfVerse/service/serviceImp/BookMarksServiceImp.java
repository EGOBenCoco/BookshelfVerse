package com.example.BookshelfVerse.service.serviceImp;

import com.example.BookshelfVerse.model.BookMarks;
import com.example.BookshelfVerse.repository.BookMarksRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class BookMarksServiceImp {
    BookMarksRepository bookMarksRepository;

    public List<BookMarks> findBookMarksByBookCollectionId(int id)
    {
        return bookMarksRepository.findByBookCollection_Id(id);
    }


    public Optional<BookMarks> findById(int id)
    {
        return bookMarksRepository.findById(id);
    }

    public void updateBookMarks(BookMarks bookMarks)
    {
        bookMarksRepository.save(bookMarks);
    }


    public void deleteBookMarksById(int id)
    {
        bookMarksRepository.deleteById(id);
    }


}
