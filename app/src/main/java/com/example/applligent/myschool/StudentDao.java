package com.example.applligent.myschool;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;
@Dao
public interface StudentDao {
        @Query("select * from Student")
        List<Student> getAll();

        @Query("select max(sId) from Student limit 1 ")
        int getMaxId();

        @Query("select * from Student where sId =:sId ")
        int getUid(int sId);

        @Query("Delete from Student where sName= :name ")
        void deleteMany(List<String> name);

        @Query("SELECT * from Student where sName like :name limit 1")
        Student findByName(String name);

        @Insert
        void insertAll(List<Student> students);

        @Insert
        void insert(Student product);

        @Update
        void update(Student product);

        @Delete
        void delete(Student product);
    }


