package com.example.examen.ui.addBook;

import androidx.lifecycle.ViewModel;

import com.example.examen.Models.Book;
import com.example.examen.Repository.Repository;

public class addBookViewModel extends ViewModel {

    public void registerBook(Book b){
        Repository.insertBook(b);
    }
}