package com.example.examen.Databases;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.examen.Models.Book;

@Database(entities = {Book.class} ,version = 1)
public abstract class RoomConnection extends RoomDatabase {

    private static RoomConnection INSTANCE;

    public static RoomConnection getRoomConnection(Context c){

        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(c,RoomConnection.class,"examen.db").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }

    public static void destroyRoomConnection() {
        INSTANCE = null;
    }
}
