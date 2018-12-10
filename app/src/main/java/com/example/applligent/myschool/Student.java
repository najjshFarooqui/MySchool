package com.example.applligent.myschool;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
@Entity
public class Student {
    @PrimaryKey(autoGenerate = true)
    public int sId;
    public String sName;
    public String sAge;
    public String sContact;
    public String sStandard;
    public String sSection;
    public String sGender;

}
