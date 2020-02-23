package com.example.examen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examen.Models.Book;

import java.util.List;

public class BooksRV extends RecyclerView.Adapter<BooksRV.BookViewHolder> {

    private List<Book> bookList;
    private NavController nc;

    public BooksRV(List<Book> bookList,NavController nc) {
        this.bookList = bookList;
        this.nc = nc;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_row_layout,parent,false);
        return new BookViewHolder(v);
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {

       holder.bookId.setText(String.valueOf(bookList.get(position).getBookId()));
       holder.bookTitle.setText(bookList.get(position).getBookTitle());
       holder.bookAuthor.setText(bookList.get(position).getBookAuthor());

    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder{
        public TextView bookId,bookAuthor,bookTitle;

        public BookViewHolder (View row){
            super(row);
            bookId = row.findViewById(R.id.txtBookId);
            bookAuthor = row.findViewById(R.id.txtBookTitle);
            bookTitle = row.findViewById(R.id.txtBookAuthor);

            // Detail
            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle b = new Bundle();
                    b.putString("Title",bookList.get(getAdapterPosition()).getBookTitle());
                    b.putString("Author",bookList.get(getAdapterPosition()).getBookAuthor());

                    nc.navigate(R.id.book_detail,b);

                }
            });

        }
    }
}
