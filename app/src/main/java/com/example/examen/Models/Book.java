package com.example.examen.Models;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Book {

    @PrimaryKey(autoGenerate = true)
    private int bookId;

    @NonNull
    private String bookTitle;

    @NonNull
    private String bookAuthor;

}
