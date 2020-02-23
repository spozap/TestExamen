package com.example.examen.Repository;

import android.content.Context;

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


}
