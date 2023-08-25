package com.example.BookshelfVerse.service.serviceImp;

import com.example.BookshelfVerse.dto.BookCollectionDTO;
import com.example.BookshelfVerse.model.BookCollection;
import com.example.BookshelfVerse.model.Customer;
import com.example.BookshelfVerse.repository.BookCollectionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookCollectionServiceImp {
    BookCollectionRepository bookCollectionRepository;


    @Transactional(readOnly = true)
    public List<BookCollectionDTO> findBookCollectionByCustomerId(int id) {
        List<BookCollection> bookCollections = bookCollectionRepository.findBookCollectionByCustomerId(id);
        return bookCollections.stream().map(BookCollectionDTO::new).toList();
    }


    public BookCollectionDTO findBookCollectionById(int id) {
        BookCollection bookCollection = bookCollectionRepository.findById(id);
        return new BookCollectionDTO(bookCollection);
    }

    public List<BookCollectionDTO> getBookCollectionByStatus(String status) {
        List<BookCollection> bookCollections = bookCollectionRepository.findBookCollectionByCollectionStatus(status);
        return bookCollections.stream().map(BookCollectionDTO::new).toList();
    }

    public void createBookCollection(BookCollection bookCollection) {
        bookCollectionRepository.save(bookCollection);
    }

    public void updateBookCollection(BookCollection bookCollection) {
        bookCollectionRepository.save(bookCollection);
    }


    public void deleteBookCollection(int id) {
        bookCollectionRepository.deleteById(id);
    }
}
