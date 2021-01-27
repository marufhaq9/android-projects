package com.example.maruf.mydatabase;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Button;
import android.database.SQLException;
import android.widget.TextView;
import android.widget.Toast;

public class GetUserInfo extends AppCompatActivity {

    ///private UserModel userModel;
    private TextView dispName, dispVarsity,dispDept, dispSession;
    //private Button btnupdate, btndelete;
    private DatabaseHelper databaseHelper;
    private int id=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_all_users);

        //Intent intent = getIntent();
        //userModel = (UserModel) intent.getSerializableExtra("student");

        //TextView dispName, dispVarsity,dispDept, dispSession;
        getIntent();
        //dispName = findViewById(R.id.showName);
        //dispVarsity = findViewById(R.id.showVarsity);
        //dispDept = findViewById(R.id.showDept);
        //dispSession = findViewById(R.id.showSession);



        /*databaseHelper = new DatabaseHelper(this);


        //SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor rs = databaseHelper.getMyData(1);
        //if(!rs.isOpen)
        rs.moveToFirst();
        String nam1 = rs.getString(rs.getColumnIndex(DatabaseHelper.KEY_FIRSTNAME));
        String nam2 = rs.getString(rs.getColumnIndex(DatabaseHelper.KEY_LASTTNAME));
        String vrsty = rs.getString(rs.getColumnIndex(DatabaseHelper.KEY_UNIVERSITY));
        String dpt = rs.getString(rs.getColumnIndex(DatabaseHelper.KEY_DEPT));
        String ss = rs.getString(rs.getColumnIndex(DatabaseHelper.KEY_SESSION));
        if (!rs.isClosed())  {
            rs.close();
        }
            //Get data
            dispName.setText(nam1 + " " + nam2);
            dispVarsity.setText(vrsty);
            dispDept.setText(dpt);
            dispSession.setText(ss);*/




    }
}
