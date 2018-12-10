package com.example.applligent.myschool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView login;
    EditText emailET;
    EditText password;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=(TextView) findViewById(R.id.textView);
        emailET=(EditText)findViewById(R.id.editText);
        password=(EditText)findViewById(R.id.editText2);
        btn=(Button)findViewById(R.id.login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(emailET.getText().toString().equals("najish.farooqui")&& password.getText().toString().equals("12345")) {
                    Intent intent = new Intent(getApplicationContext(), StudentRegistration.class);
                    startActivity(intent);
                }else{Log.i("success","failed to login");}
            }
        });

    }
}
