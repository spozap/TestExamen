package com.example.examen.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.examen.Models.Book;
import com.example.examen.Repository.Repository;

public class HomeViewModel extends ViewModel {

    public void registerBook(Book b){
        Repository.insertBook(b);
    }
}