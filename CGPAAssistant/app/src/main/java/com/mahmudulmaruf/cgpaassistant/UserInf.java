package com.mahmudulmaruf.cgpaassistant;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserInf extends AppCompatActivity {

    EditText a1, a2, a3, a4, a5;
    Button crt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_signup);

        final MyDB db = new MyDB(this);

        a1 = findViewById(R.id.input_name);
        final String ab1 = a1.getText().toString().trim();
        a2 = findViewById(R.id.input_varsity);
        final String ab2 = a2.getText().toString().trim();
        a3 = findViewById(R.id.input_dept);
        final String ab3 = a3.getText().toString().trim();
        a4 = findViewById(R.id.input_session);
        final String ab4 = a4.getText().toString().trim();
        a5 = findViewById(R.id.input_password);
        final String ab5 = a5.getText().toString().trim();
        //
        crt = findViewById(R.id.btn_signup);
        crt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a1.getText().toString().matches("")||a2.getText().toString().matches("")||a3.getText().toString().matches("")||a4.getText().toString().matches("")||a5.getText().toString().matches(""))
                    Toast.makeText(UserInf.this,"Fill the forms first",Toast.LENGTH_SHORT).show();
                else {
                    Log.d("Insert: ", "Inserting ..");
                    db.AddInfo(new InsertInfo(ab1,ab2,ab3,ab4,ab5));
                    db.close();
                    Toast.makeText(UserInf.this,"Information added successfully",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(UserInf.this, UserMain.class);
                    startActivity(i);
                    finish();
                    //i=1;
                }
            }
        });

    }

}
