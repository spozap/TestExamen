package com.example.examen.Dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.examen.Models.Book;

@Dao
public interface bookDao {

    @Insert
    void insertBook(Book b);

    @Query("SELECT * FROM  Book where bookTitle = :title")
    Book checkBookExists(String title);


}
