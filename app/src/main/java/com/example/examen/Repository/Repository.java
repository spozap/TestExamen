package com.example.examen.Repository;

import android.content.Context;
import android.widget.Toast;

import com.example.examen.Databases.RoomConnection;
import com.example.examen.Models.Book;

import java.util.List;

public class Repository {


    private static Context c;
    private static Repository srepository;

    private Repository(Context c){
        this.c = c;
    }


    public static Repository get(Context context) {
        if (srepository == null) {
            srepository = new Repository(context);
        }
        return srepository;
    }


    // Room CRUD

    public static void insertBook(Book b){
        RoomConnection ro = RoomConnection.getRoomConnection(c);

        if (ro.bookDao().checkBookExists(b.getBookTitle()) == null){
            ro.bookDao().insertBook(b);
            Toast.makeText(c,"Libro registrado",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(c,"El libro ya existe",Toast.LENGTH_SHORT).show();
        }

        ro.destroyRoomConnection();
        ro.close();

    }

    public static List<Book> getBookList(){
        RoomConnection ro = RoomConnection.getRoomConnection(c);
        List<Book> bookList = ro.bookDao().getBooks();

        ro.destroyRoomConnection();
        ro.close();

        return bookList;
    }

    // End Room

}
