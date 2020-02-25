package com.example.examen.ui.deleteBook;

import androidx.lifecycle.ViewModel;

import com.example.examen.Repository.Repository;

public class deleteBookViewModel extends ViewModel {

    public void removeBook(String title){
        Repository.removeBook(title);
    }
}