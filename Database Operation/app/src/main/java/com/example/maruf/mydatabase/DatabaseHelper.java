package com.example.maruf.mydatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    //
    public static String DATABASE_NAME = "student_database";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_STUDENTS = "students";
    public static final String KEY_ID = "id";
    public static final String KEY_FIRSTNAME = "fname";
    public static final String KEY_LASTTNAME = "lname";
    public static final String KEY_DEPT = "dept";
    public static final String KEY_UNIVERSITY = "varsity";
    public static final String KEY_SESSION = "session";

    //db path
    private static String DB_PATH = "/data/data/MyDataBase/databases/";
    private SQLiteDatabase myDataBase;

    public void openDataBase() throws SQLException {
        //Open the database
        String myPath = DB_PATH + DATABASE_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
    }

    private static final String CREATE_TABLE_STUDENTS = "CREATE TABLE "
            + TABLE_STUDENTS + "(" + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_FIRSTNAME + " TEXT, " + KEY_LASTTNAME + " TEXT, " + KEY_UNIVERSITY + " TEXT, " + KEY_DEPT + " TEXT, " + KEY_SESSION + "TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        Log.d("table", CREATE_TABLE_STUDENTS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_STUDENTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_STUDENTS + "'");
        onCreate(db);
    }

    public void addStudentDetail(String fname, String lname, String varsity, String dept, String stsession) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Creating content values
        ContentValues values = new ContentValues();
        values.put(KEY_FIRSTNAME, fname);
        values.put(KEY_LASTTNAME, lname);
        values.put(KEY_UNIVERSITY, varsity);
        values.put(KEY_DEPT, dept);
        values.put(KEY_SESSION, stsession);
        // insert row in students table
        try {
            db.insert(TABLE_STUDENTS, null, values);
        }catch (Exception e){
            System.out.println();
        }

    }

    public ArrayList<UserModel> getAllUsers() {
        ArrayList<UserModel> userModelArrayList = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + TABLE_STUDENTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                UserModel userModel = new UserModel();
                userModel.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                userModel.setName(c.getString(c.getColumnIndex(KEY_FIRSTNAME)));
                userModel.setLname(c.getString(c.getColumnIndex(KEY_LASTTNAME)));
                userModel.setVarsity(c.getString(c.getColumnIndex(KEY_UNIVERSITY)));
                userModel.setDept(c.getString(c.getColumnIndex(KEY_DEPT)));
                userModel.setSessions(c.getString(c.getColumnIndex(KEY_SESSION)));
                // adding to Students list
                userModelArrayList.add(userModel);
            } while (c.moveToNext());
        }
        return userModelArrayList;
    }

    public int updateUser(int id, String name, String lname, String varsity, String dept, String session) {
        SQLiteDatabase db = this.getWritableDatabase();

        // Creating content values
        ContentValues values = new ContentValues();
        values.put(KEY_FIRSTNAME, name);
        values.put(KEY_LASTTNAME, lname);
        values.put(KEY_UNIVERSITY, varsity);
        values.put(KEY_DEPT, dept);
        values.put(KEY_SESSION, session);
        // update row in students table base on students.is value
        return db.update(TABLE_STUDENTS, values, KEY_ID + " = ?",
                new String[]{String.valueOf(id)});
    }

    public void deleteUSer(int id) {

        // delete row in students table based on id
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_STUDENTS, KEY_ID + " = ?",
                new String[]{String.valueOf(id)});
    }


}