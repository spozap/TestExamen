package com.example.examen.ui.addCustomer;

import androidx.lifecycle.ViewModel;

import com.example.examen.Models.Customer;
import com.example.examen.Repository.Repository;

public class addCustomerViewModel extends ViewModel {

    public void insertCustomer(Customer c){
        Repository.insertCustomer(c);
    }

}