package com.example.examen.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.examen.Models.Book;
import com.example.examen.Repository.Repository;

import java.util.List;

public class GalleryViewModel extends ViewModel {

    public List<Book> getBooks(){
        return Repository.getBookList();
    }
}