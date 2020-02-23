package com.example.examen.Repository;

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Repository.get(this);
    }

}
