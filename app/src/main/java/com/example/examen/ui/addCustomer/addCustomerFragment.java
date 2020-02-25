package com.example.examen.ui.addCustomer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.examen.Models.Customer;
import com.example.examen.R;

public class addCustomerFragment extends Fragment {

    private addCustomerViewModel addCustomerViewModel;

    private EditText customerName,customerSurname,customerDni;
    private Button registerCustomer;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        addCustomerViewModel =
                ViewModelProviders.of(this).get(addCustomerViewModel.class);
        View root = inflater.inflate(R.layout.add_customer, container, false);

        customerName = root.findViewById(R.id.customerName);
        customerSurname = root.findViewById(R.id.customerSurname);
        customerDni = root.findViewById(R.id.customerDni);

        registerCustomer = root.findViewById(R.id.insertCustomer);

        registerCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               addCustomerViewModel.insertCustomer(new Customer(customerName.getText().toString(),
                       customerSurname.getText().toString(),
                       customerDni.getText().toString()));
            }
        });

        return root;
    }
}