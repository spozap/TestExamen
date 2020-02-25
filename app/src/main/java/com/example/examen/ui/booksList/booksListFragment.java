package com.example.examen.ui.booksList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examen.BooksRV;
import com.example.examen.Models.Book;
import com.example.examen.R;

import java.util.List;

public class booksListFragment extends Fragment {

    private booksListViewModel booksListViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        booksListViewModel =
                ViewModelProviders.of(this).get(booksListViewModel.class);
        View root = inflater.inflate(R.layout.books_list, container, false);

        RecyclerView rv_book;

        rv_book = root.findViewById(R.id.booksRV);
        rv_book.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Book> books = booksListViewModel.getBooks();
        BooksRV brv = new BooksRV(books, Navigation.findNavController(getActivity(),R.id.nav_host_fragment));
        rv_book.setAdapter(brv);

        return root;
    }
}