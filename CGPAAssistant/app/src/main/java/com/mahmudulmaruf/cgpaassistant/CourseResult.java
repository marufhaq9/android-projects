package com.mahmudulmaruf.cgpaassistant;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CourseResult extends Activity {
    EditText et1,et2,et3,et4,et5;
    TextView tv1,tv2,tv3;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_signup);
        et1 = findViewById(R.id.input_name);
        et2 = findViewById(R.id.input_varsity);
        et3 = findViewById(R.id.input_dept);
        et4 = findViewById(R.id.input_session);
        et5 = findViewById(R.id.input_password);
        //tv3 = findViewById(R.id.tv3);
    }

    public void saveIntoSQLite(View v)
    {
        //id = et1.getText().toString().trim();
        String name = et1.getText().toString().trim();
        String varsity = et2.getText().toString().trim();
        String dept = et3.getText().toString().trim();
        String session = et4.getText().toString().trim();
        String pswrd = et5.getText().toString().trim();

        MyDB mdb = new MyDB(this);
        SQLiteDatabase db = mdb.getWritableDatabase();

        /*try {
            ContentValues cv=new ContentValues();
            cv.put(MyDB.NAME,name);
            cv.put(MyDB.VARSITY,varsity);
            cv.put(MyDB.DEPT,dept);
            db.insert(MyDB.TABLE_NAME,null,cv);
            et1.setText("");
            et2.setText("");
            et3.setText("");
        }
        catch (Exception e)
        {
            Log.e("Insert Exception",""+e);
        }*/
        String col[]={MyDB.VARSITY,MyDB.DEPT,MyDB.SESSION,MyDB.PASSWORD};
        String wer=MyDB.NAME+"=?";
        String val[]={name};
        Cursor c= db.query(MyDB.TABLE_NAME,col,wer,val,null,null,null,null);
        if(c.moveToFirst())
        {
            String name1= c.getString(0);
            String idno1= c.getString(1);
            String sal1= c.getString(2);
            tv1.setText(name1);
            tv2.setText(idno1);
            tv3.setText(sal1);
        }
        db.delete(MyDB.TABLE_NAME,wer,val);
    }
    public void view1(View v)
    {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
