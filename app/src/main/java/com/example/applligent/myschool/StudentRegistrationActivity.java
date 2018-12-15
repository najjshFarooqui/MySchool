package com.example.applligent.myschool;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.applligent.myschool.databinding.ActivityStudentRegistrationBinding;

public class StudentRegistrationActivity extends AppCompatActivity {
    StudentDao studentDao;
    ActivityStudentRegistrationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_student_registration);
        studentDao = MySchoolApplication.getDatabase().studentDao();

        //spinner code
        String[] standarsSpinner = new String[]{"Standard", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        ArrayAdapter<String> StandardAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, standarsSpinner);
        StandardAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.standardSpinner.setAdapter(StandardAdapter);

        String[] spinnerSection = new String[]{"Section", "A", "B", "C"};
        ArrayAdapter<String> sectionAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, spinnerSection);
        sectionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.sectionSpinner.setAdapter(sectionAdapter);


        String[] genderSpinner = new String[]{"Gender", "Male", "Female"};
        ArrayAdapter<String> genderAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, genderSpinner);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.genderSpinner.setAdapter(genderAdapter);


        binding.insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student();
                student.sName = binding.nameField.getText().toString();
                student.sAge = binding.ageField.getText().toString();
                student.sContact = binding.phoneField.getText().toString();
                student.sStandard = binding.standardSpinner.getSelectedItem().toString();
                student.sSection = binding.sectionSpinner.getSelectedItem().toString();
                student.sGender = binding.genderSpinner.getSelectedItem().toString();
                studentDao.insert(student);
                Intent intent = new Intent(getApplicationContext(), StudentListActivity.class);
                startActivity(intent);

            }
        });
    }
}
//when Button is pressed


