package com.example.applligent.myschool;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.applligent.myschool.databinding.ActivityStudentListBinding;

import java.util.List;

public class StudentListActivity extends AppCompatActivity {
    StudentAdapter studentAdapter;
    Student studentName;
    ActivityStudentListBinding binding;
    StudentDao studentDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_student_list);
        studentDao = MySchoolApplication.getDatabase().studentDao();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StudentRegistrationActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Student> list = studentDao.getAll();
        binding.recyclerView.setAdapter(new StudentAdapter(list));
    }
}
