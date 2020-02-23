package com.example.examen.ui.slideshow;

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

import com.example.examen.R;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;

    private EditText bookTitle;
    private Button bookRemove;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        bookTitle = root.findViewById(R.id.titleBook);
        bookRemove = root.findViewById(R.id.removeBook);

        bookRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slideshowViewModel.removeBook(bookTitle.getText().toString());
            }
        });

        return root;
    }
}