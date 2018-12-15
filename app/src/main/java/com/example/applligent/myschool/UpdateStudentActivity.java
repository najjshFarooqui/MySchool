package com.example.applligent.myschool;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.applligent.myschool.databinding.ActivityUpdateStudentBinding;

public class UpdateStudentActivity extends AppCompatActivity {
    ActivityUpdateStudentBinding binding;
    StudentDao studentDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_student);
        studentDao = MySchoolApplication.getDatabase().studentDao();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_update_student);

        Student student = getIntent().getParcelableExtra("arg_student");
        binding.setStudent(student);
        binding.updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: validate fields
                studentDao.update(binding.getStudent());
                finish();
            }
        });
    }
}
