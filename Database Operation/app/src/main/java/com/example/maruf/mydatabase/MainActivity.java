package com.example.maruf.mydatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnStore, btnGetall;
    private EditText fname, lname, varsity, dept, etsession;
    private DatabaseHelper databaseHelper;
    private TextView tvnames;
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        //tvnames = findViewById(R.id.tvnames);

        btnStore = findViewById(R.id.btnstore);
        btnGetall = findViewById(R.id.btnget);
        fname = findViewById(R.id.etfname);
        lname = findViewById(R.id.etlname);
        varsity = findViewById(R.id.etvarsity);
        dept = findViewById(R.id.etdept);
        etsession = findViewById(R.id.etsession);

        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 databaseHelper.addStudentDetail(fname.getText().toString().trim(), lname.getText().toString().trim(), varsity.getText().toString().trim(), dept.getText().toString().trim(), etsession.getText().toString().trim());
                //etname.setText("");
                /*if(check == -1)
                    Toast.makeText(MainActivity.this, "Something wrong!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Stored Successfully!", Toast.LENGTH_SHORT).show();*/

            }
        });

        btnGetall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,GetAllUsersActivity.class);
                startActivity(intent);
                //finish();
            }
        });

    }
        public boolean onKeyDown(int keycode, KeyEvent event) {
            if (keycode == KeyEvent.KEYCODE_BACK) {
                moveTaskToBack(true);
            }
            return super.onKeyDown(keycode, event);
        }
}
