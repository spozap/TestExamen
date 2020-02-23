package com.example.examen.ui.slideshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.examen.Models.Book;
import com.example.examen.Repository.Repository;

public class SlideshowViewModel extends ViewModel {

    public void removeBook(String title){
        Repository.removeBook(title);
    }
}