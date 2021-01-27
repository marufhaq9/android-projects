package com.maruf.banglaquran;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "AlQuran";
    private static final String TABLE_NAME = "quranbangla";
    private static final String KEY_DBID = "db_id";
    private static final String KEY_ID = "surah_id";
    private static final String KEY_NAME = "surah_name";
    private static final String KEY_VERSE = "verse_id";
    private static final String KEY_ARABIC = "AyahArabic";
    private static final String KEY_BANGLA = "AyahBangla";

    public DbHelper(Context context){
        super(context,DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_DBID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT,"
                + KEY_ID + " TEXT,"
                + KEY_VERSE + " TEXT,"
                + KEY_ARABIC + " TEXT,"
                + KEY_BANGLA + " TEXT" + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        // Drop older table if exist
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        // Create tables again
        onCreate(db);
    }

    public ArrayList<DataModel> GetSurahs() {
        SQLiteDatabase db = this.getWritableDatabase();
        //ArrayList<HashMap<String, String>> userList = new ArrayList<>();
        ArrayList<DataModel> userList = new ArrayList<>();
        String query = "SELECT surah_id, surah_name, verse_id, AyahArabic, AyahBangla FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        /*if (cursor.moveToFirst()) {
            do {
                //DataModel doctor = new DataModel();
                doctor.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
                doctor.setName(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
                doctor.setDesignation(cursor.getString(cursor.getColumnIndex(KEY_DESG)));
                doctor.setLocation(cursor.getString(cursor.getColumnIndex(KEY_LOC)));
                doctor.setContact(cursor.getString(cursor.getColumnIndex(KEY_CONTACT)));
                userList.add(doctor);
            } while (cursor.moveToNext());
        }*/
        return userList;
    }

}
