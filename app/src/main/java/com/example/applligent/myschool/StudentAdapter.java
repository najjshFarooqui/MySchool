package com.example.applligent.myschool;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentHolder> {
    List<Student> students;

    public StudentAdapter(List<Student> students) {
        this.students = students;
    }

    @NonNull
    @Override
    public StudentAdapter.StudentHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.student_view, viewGroup, false);
        return new StudentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentHolder studentHolder, int i) {
        studentHolder.bindTo(students.get(i));

    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    protected class StudentHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;

        public StudentHolder(@NonNull final View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.circleImage);
            name = itemView.findViewById(R.id.studentName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Student student = students.get(getAdapterPosition());
                    Intent intent = new Intent(itemView.getContext(), DetailsActivity.class);
                    intent.putExtra("arg_student_id", student.sId);
                    itemView.getContext().startActivity(intent);
                }
            });
        }

        protected void bindTo(Student student) {
            name.setText(student.sName);
        }
    }
}

