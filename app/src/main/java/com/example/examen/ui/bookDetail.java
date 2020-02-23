package com.example.examen.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.examen.R;

public class bookDetail extends Fragment {

    TextView bookTitle,bookAuthor;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.book_detail,container,false);

        bookAuthor = root.findViewById(R.id.showAuthor);
        bookTitle = root.findViewById(R.id.showTitle);

        if (getArguments() != null){
            bookAuthor.setText(getArguments().getString("Author"));
            bookTitle.setText(getArguments().getString("Title"));
        }
        return root;
    }
}
