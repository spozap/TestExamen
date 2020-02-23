package com.example.examen.ui.tools;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.examen.Models.Customer;
import com.example.examen.Repository.Repository;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class ToolsViewModel extends ViewModel {

    public void insertCustomer(Customer c){
        Repository.insertCustomer(c);
    }

}