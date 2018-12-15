package com.example.applligent.myschool;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.applligent.myschool.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {
    int studentId;
    Student student;
    ActivityDetailsBinding binding;
    StudentDao studentDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        studentDao = MySchoolApplication.getDatabase().studentDao();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details);
        studentId = getIntent().getIntExtra("arg_student_id", -1);
    }

    @Override
    protected void onResume() {
        super.onResume();
        student = studentDao.get(studentId);
        binding.setStudent(student);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.delete) {
            studentDao.delete(student);
            Toast.makeText(this, "delete selected", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.update) {
            Intent intent = new Intent(getApplicationContext(), UpdateStudentActivity.class);
            intent.putExtra("arg_student", student);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
