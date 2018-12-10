package com.example.applligent.myschool;

import android.app.Application;
import android.arch.persistence.room.Room;

public class MySchoolApplication extends Application {
    final static String DATABASE_NAME = "db-school-demo";
    private static MyDatabase myDatabase;
    private static MySchoolApplication mySchoolApplication;

    public static MyDatabase getDatabase() {
        if (myDatabase == null) {
            myDatabase = Room.databaseBuilder(mySchoolApplication,
                    MyDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return myDatabase;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mySchoolApplication = this;
    }
}
