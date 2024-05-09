package com.example.academicplanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class signup extends AppCompatActivity {

    EditText fullname, username, password, retype;
    Button register;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        fullname = (EditText) findViewById(R.id.txtfullname);
        username = (EditText) findViewById(R.id.txtusername);
        password = (EditText) findViewById(R.id.txtpassword);
        retype = (EditText) findViewById(R.id.txtretype);
        register = (Button) findViewById(R.id.btnregister);
        db = new DBHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String full=fullname.getText().toString();
                String user=username.getText().toString();
                String pw=password.getText().toString();
                String repw=retype.getText().toString();

                if(full.isEmpty()||user.isEmpty()||pw.isEmpty()||repw.isEmpty())
                {
                    Toast.makeText(signup.this,"Missing Fields",Toast.LENGTH_SHORT).show(); }
                else
                {
                    //check if password is same as the retype password//
                    if (pw.equals(repw)){
                        Boolean checkuser=db.checkUsername(user);
                        if(checkuser.equals(false))
                        {
                            Boolean insert=db.insert(user,pw);
                            if(insert.equals(true)) {
                                Toast.makeText(signup.this,"Succesfully Registered",Toast.LENGTH_SHORT).show();
                                Intent i=new Intent(signup.this,MainActivity.class); startActivity(i);
                            }
                            else{
                                Toast.makeText(signup.this,"Unsuccessful Registration",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(signup.this,"User Already Exist",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(signup.this,"Password does not match",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}