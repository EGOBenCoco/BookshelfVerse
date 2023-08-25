package com.example.BookshelfVerse.repository;

import com.example.BookshelfVerse.model.Book;
import com.example.BookshelfVerse.model.BookMarks;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMarksRepository extends JpaRepository<BookMarks,Integer>
{
    List<BookMarks> findByBookCollection_Id(int id);
}
