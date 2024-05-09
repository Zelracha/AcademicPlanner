package com.example.academicplanner;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

public class login extends AppCompatActivity {

    Button login;
    EditText usernm, pass;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (Button) findViewById(R.id.btnlogin2);
        usernm = (EditText) findViewById(R.id.txtuser);
        pass = (EditText) findViewById(R.id.txtpass);
        db = new DBHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = usernm.getText().toString();
                String pw = pass.getText().toString();
                if (user.isEmpty() || pw.isEmpty()) {
                    Toast.makeText(login.this, "Missing Fields", Toast.LENGTH_SHORT).show();
                } else {

                    Boolean checkuserpw = db.checkUsernamepassowrd(user, pw);

                    if (checkuserpw.equals(true)) {
                        Intent i=new Intent(login.this,Planner.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(login.this, "Unsuccessful Login", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}