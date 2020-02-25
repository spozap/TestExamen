package com.example.examen.ui.booksList;

import androidx.lifecycle.ViewModel;

import com.example.examen.Models.Book;
import com.example.examen.Repository.Repository;

import java.util.List;

public class booksListViewModel extends ViewModel {

    public List<Book> getBooks(){
        return Repository.getBookList();
    }
}