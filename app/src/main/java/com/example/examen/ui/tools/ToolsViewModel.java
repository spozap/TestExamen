package com.example.examen.ui.tools;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.examen.Models.Customer;
import com.example.examen.Repository.Repository;

public class ToolsViewModel extends ViewModel {

    public void insertCustomer(Customer c){
        Repository.insertCustomer(c);
    }
}