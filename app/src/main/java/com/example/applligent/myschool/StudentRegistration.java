package com.example.applligent.myschool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class StudentRegistration extends AppCompatActivity {
    StudentDao studentDao;
    EditText name;
    EditText phone;
    EditText age;
    Spinner standard;
    Spinner section;
    Spinner gender;
    Button insertButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_registration);
        name = (EditText) findViewById(R.id.student_name);
        phone = (EditText) findViewById(R.id.student_phone);
        age = (EditText) findViewById(R.id.age);


        //spinner code
        standard = (Spinner) findViewById(R.id.student_class);
        String[] standarsSpinner = new String[]{"Standard", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        ArrayAdapter<String> StandardAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, standarsSpinner);
        StandardAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        standard.setAdapter(StandardAdapter);

        section = (Spinner) findViewById(R.id.section);
        String[] spinnerSection = new String[]{"Section", "A", "B", "C"};
        ArrayAdapter<String> sectionAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, spinnerSection);
        sectionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        section.setAdapter(sectionAdapter);


        gender = (Spinner) findViewById(R.id.gender);
        String[] genderSpinner = new String[]{"Gender", "Male", "Female"};
        ArrayAdapter<String> genderAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, genderSpinner);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(genderAdapter);
        insertButton=(Button)findViewById(R.id.create_button);
        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student =new Student();
                student.sName=name.getText().toString();
                student.sAge=age.getText().toString();
                student.sContact=phone.getText().toString();
                student.sStandard=standard.getSelectedItem().toString();
                student.sSection=section.getSelectedItem().toString();
                student.sGender=gender.getSelectedItem().toString();
                List<Student> students = new ArrayList<>();
                students.add(student);
                studentDao.insertAll(students);

            }
        });
    }
}
        //when Button is pressed


