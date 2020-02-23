package com.example.examen.ui.tools;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.examen.Models.Customer;
import com.example.examen.R;

public class ToolsFragment extends Fragment {

    private ToolsViewModel toolsViewModel;

    private EditText customerName,customerSurname,customerDni;
    private Button registerCustomer;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        toolsViewModel =
                ViewModelProviders.of(this).get(ToolsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tools, container, false);

        customerName = root.findViewById(R.id.customerName);
        customerSurname = root.findViewById(R.id.customerSurname);
        customerDni = root.findViewById(R.id.customerDni);

        registerCustomer = root.findViewById(R.id.insertCustomer);

        registerCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               toolsViewModel.insertCustomer(new Customer(customerName.getText().toString(),
                       customerSurname.getText().toString(),
                       customerDni.getText().toString()));
            }
        });

        return root;
    }
}