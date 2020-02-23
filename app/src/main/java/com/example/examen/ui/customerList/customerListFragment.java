package com.example.examen.ui.customerList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examen.CustomerRV;
import com.example.examen.Models.Customer;
import com.example.examen.R;

import java.util.ArrayList;
import java.util.List;

public class customerListFragment extends Fragment {

    private CustomerListViewModel customerListViewModel;
    private List<Customer> customerList = new ArrayList<>();
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        customerListViewModel =
                ViewModelProviders.of(this).get(CustomerListViewModel.class);
        View root = inflater.inflate(R.layout.customer_rv, container, false);

        RecyclerView customerRV = root.findViewById(R.id.customersRV);
        customerRV.setLayoutManager(new LinearLayoutManager(getContext()));

        final CustomerRV adapter = new CustomerRV(customerList);

        customerListViewModel.getCustomers();
        customerListViewModel.getCustList().observe(getViewLifecycleOwner(),
                new Observer<List<Customer>>() {
                    @Override
                    public void onChanged(List<Customer> customers) {
                       customerList = customers;
                       adapter.setCustomerList(customerList);
                       adapter.notifyDataSetChanged();
                    }
                });
        //customerList.clear(); // Made to avoid duplicate data
        customerRV.setAdapter(adapter);

        return root;
    }
}
