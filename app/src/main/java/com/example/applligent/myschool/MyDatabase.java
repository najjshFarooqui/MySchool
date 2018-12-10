package com.example.applligent.myschool;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = Student.class, version = 1, exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {
    public abstract StudentDao studentDao();
}
