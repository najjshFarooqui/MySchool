package com.example.applligent.myschool;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

@Entity
public class Student implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    public int sId;
    public String sName;
    public String sAge;
    public String sContact;
    public String sStandard;
    public String sSection;
    public String sGender;

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public Student() {

    }

    protected Student(Parcel in) {
        sId = in.readInt();
        sName = in.readString();
        sAge = in.readString();
        sContact = in.readString();
        sStandard = in.readString();
        sSection = in.readString();
        sGender = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(sId);
        dest.writeString(sName);
        dest.writeString(sAge);
        dest.writeString(sContact);
        dest.writeString(sStandard);
        dest.writeString(sSection);
        dest.writeString(sGender);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
