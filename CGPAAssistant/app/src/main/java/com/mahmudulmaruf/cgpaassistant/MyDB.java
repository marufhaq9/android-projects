package com.mahmudulmaruf.cgpaassistant;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDB extends SQLiteOpenHelper {
    Context context;
    public static final int VERSION = 1;
    public static final String DBNAME = "CGPA_Maruf";
    public static final String TABLE_NAME = "UserCgpa";
    public static final String ID="id";
    public static final String NAME="name";
    public static final String VARSITY="varsity";
    public static final String DEPT="dept";
    public static final String SESSION = "session";
    public static final String PASSWORD = "password";


    public MyDB(Context context)
    {
        super(context,DBNAME,null,VERSION);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        try
        {
            String DataBase_Table = "CREATE TABLE " + TABLE_NAME + "(" + ID + "INTEGER PRIMARY KEY," + NAME + "TEXT," + VARSITY + "TEXT," + DEPT + "TEXT," + SESSION + "TEXT," + PASSWORD + "TEXT" +")";
            db.execSQL(DataBase_Table);
            //db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(id integer primary key, name VARCHAR, varsity VARCHAR, dept VARCHAR, session VARCHAR, password VARCHAR);");
        }catch (Exception e)
        {
            Log.e("Table Creation",""+e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //Insert into db
    void AddInfo(InsertInfo insertInfo){
        SQLiteDatabase db =this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME,insertInfo.getName());
        values.put(VARSITY,insertInfo.getVarsity());
        values.put(DEPT,insertInfo.getDept());
        values.put(SESSION,insertInfo.getSession());
        values.put(PASSWORD,insertInfo.getPass());

        // Inserting Row
        db.insert(TABLE_NAME, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection

    }

    //Code to get single information
    public Cursor getInfo(int id)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[]{ID,NAME,VARSITY,DEPT,SESSION,PASSWORD},ID + "=?",
                new String[] {String.valueOf(id)}, null, null, null, null);
        if(cursor!=null)
            cursor.moveToFirst();

        //InsertInfo insertInfo = new InsertInfo(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4), cursor.getString(5));
        return cursor;
    }

}