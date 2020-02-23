package com.example.examen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examen.Models.Customer;

import java.util.List;

public class CustomerRV extends RecyclerView.Adapter<CustomerRV.CustomerViewHolder> {

    private List<Customer> customerList;

    public CustomerRV(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.customers_row,parent,false);
        return new CustomerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder holder, int position) {
        holder.custName.setText(customerList.get(position).getName());
        holder.custSurname.setText(customerList.get(position).getSurname());
        holder.custDni.setText(customerList.get(position).getDNI());
    }

    @Override
    public int getItemCount() {
        return customerList.size();
    }


    public class CustomerViewHolder extends RecyclerView.ViewHolder{
        private TextView custName,custSurname,custDni;

        public CustomerViewHolder(View row){
            super(row);
            custName = row.findViewById(R.id.showCustomerName);
            custSurname = row.findViewById(R.id.showCustomerSurname);
            custDni = row.findViewById(R.id.showCustomerDni);

        }
    }
}
