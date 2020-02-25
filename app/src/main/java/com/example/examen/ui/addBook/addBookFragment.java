package com.example.examen.ui.addBook;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.examen.Models.Book;
import com.example.examen.R;

public class addBookFragment extends Fragment {

    private addBookViewModel addBookViewModel;
    private EditText bookTitle,bookAuthor;
    private Button newBook;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        addBookViewModel =
                ViewModelProviders.of(this).get(addBookViewModel.class);
        View root = inflater.inflate(R.layout.add_book, container, false);

        bookTitle = root.findViewById(R.id.bookTitle);
        bookAuthor = root.findViewById(R.id.bookAuthor);

        newBook = root.findViewById(R.id.newBook);


        newBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Book b = new Book();
            b.setBookAuthor(bookAuthor.getText().toString());
            b.setBookTitle(bookTitle.getText().toString());

            addBookViewModel.registerBook(b);

            }
        });

        return root;
    }
}