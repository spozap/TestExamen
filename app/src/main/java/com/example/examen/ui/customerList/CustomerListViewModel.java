package com.example.examen.ui.customerList;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.examen.Models.Customer;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CustomerListViewModel extends ViewModel {

    private MutableLiveData<List<Customer>> custList;
    private List<Customer> customers;

    public CustomerListViewModel() {
        custList = new MutableLiveData<>();
        customers = new ArrayList<>();
    }

    public MutableLiveData<List<Customer>> getCustList() {
        return custList;
    }

    public void getCustomers(){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

        DatabaseReference ref = firebaseDatabase.getReference().child("Customers");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot d : dataSnapshot.getChildren()){
                    customers.add(d.getValue(Customer.class));
                    custList.postValue(customers);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
