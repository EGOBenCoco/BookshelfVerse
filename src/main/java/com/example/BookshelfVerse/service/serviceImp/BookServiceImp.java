package com.example.BookshelfVerse.service.serviceImp;

import com.example.BookshelfVerse.dto.BookDTO;
import com.example.BookshelfVerse.model.Book;
import com.example.BookshelfVerse.enumModel.GenreName;
import com.example.BookshelfVerse.repository.BookRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookServiceImp {
    BookRepository bookRepository;

    public Page<Book> getBooksByGenre(GenreName genreName, Pageable pageable) {
        return bookRepository.findByGenreName(genreName, pageable);
    }

    public Page<Book> getBookByLanguage(String language, Pageable pageable) {
        return bookRepository.findAllByLanguage(language, pageable);
    }

    public Page<Book> getBookByName(String name, Pageable pageable) {
        return bookRepository.findBookByName(name, pageable);
    }

    public Page<Book> getSortedAndFilteredBooks(GenreName genreName, String language, String name, Pageable pageable) {
        if (genreName != null) {
            return getBooksByGenre(genreName, pageable);
        }
        if (language != null) {
            return getBookByLanguage(language, pageable);
        }
        if (name != null) {
            return getBookByName(name, pageable);
        }

        return bookRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Optional<Book> findBookById(int id) {
        return bookRepository.findById(id);

    }


    public Page<Book> findAllBook(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    public void createBook(Book book) {
        bookRepository.save(book);
    }

    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBookById(int id) {
        bookRepository.deleteById(id);
    }

}
