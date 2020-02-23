package com.example.examen.Repository;

import android.content.Context;
import android.widget.Toast;

import com.example.examen.Databases.RoomConnection;
import com.example.examen.Models.Book;
import com.example.examen.Models.Customer;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class Repository {


    private static Context c;
    private static Repository srepository;
    private static FirebaseDatabase firebaseDatabase;

    private Repository(Context c){
        this.c = c;
        firebaseDatabase = FirebaseDatabase.getInstance();
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

    public static void removeBook(String title){
        RoomConnection ro = RoomConnection.getRoomConnection(c);

        // Si el libro existe , cojer el objeto y borrarlo
        if (ro.bookDao().checkBookExists(title) != null ){
            Book b = ro.bookDao().getBook(title);
            ro.bookDao().deleteBook(b);
            Toast.makeText(c,"Libro borrado",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(c,"No existe el libro",Toast.LENGTH_SHORT).show();
        }

        ro.destroyRoomConnection();
        ro.close();
    }
    // End Room

    // Firebase

    public static void insertCustomer(Customer cu){
        DatabaseReference ref = firebaseDatabase.getReference().child("Customers");
        ref.push().setValue(cu);
        Toast.makeText(c,"Cliente registrado",Toast.LENGTH_SHORT).show();
    }

    // End Firebase
}
