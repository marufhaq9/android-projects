package com.mahmudulmaruf.cgpaassistant;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class UserMain extends AppCompatActivity {
    TextView t1, t2, t3, t4;// t5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_info);
        //Db
        final MyDB db = new MyDB(this);
        t1 = findViewById(R.id.DispName);
        t2 = findViewById(R.id.DispVrsty);
        t3 = findViewById(R.id.DispDept);
        t4 = findViewById(R.id.DispSession);

        //Opening db
        db.getReadableDatabase();
        // Reading all contacts
        Log.d("Reading: ", "Reading User Information..");

        Cursor cursor = db.getInfo(1);
        cursor.moveToFirst();
        t1.setText(cursor.getString(1));
        t2.setText(cursor.getString(2));
        t3.setText(cursor.getString(3));
        t4.setText(cursor.getString(4));
        //t5.setText(cursor.getString(5));

    }
}
