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

    ////////////////////////////////////////

    public Book() {
    }


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @NonNull
    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(@NonNull String bookTitle) {
        this.bookTitle = bookTitle;
    }

    @NonNull
    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(@NonNull String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }
}
