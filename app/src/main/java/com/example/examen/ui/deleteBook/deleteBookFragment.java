package com.example.examen.ui.deleteBook;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.examen.R;

public class deleteBookFragment extends Fragment {

    private deleteBookViewModel deleteBookViewModel;

    private EditText bookTitle;
    private Button bookRemove;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        deleteBookViewModel =
                ViewModelProviders.of(this).get(deleteBookViewModel.class);
        View root = inflater.inflate(R.layout.delete_book, container, false);

        bookTitle = root.findViewById(R.id.titleBook);
        bookRemove = root.findViewById(R.id.removeBook);

        bookRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteBookViewModel.removeBook(bookTitle.getText().toString());
            }
        });

        return root;
    }
}