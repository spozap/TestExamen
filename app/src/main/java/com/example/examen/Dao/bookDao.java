package com.example.examen.Dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.examen.Models.Book;

import java.util.List;

@Dao
public interface bookDao {

    @Insert
    void insertBook(Book b);

    @Query("SELECT * FROM  Book where bookTitle = :title")
    Book checkBookExists(String title);

    @Query("SELECT * FROM Book")
    List<Book> getBooks();
}
