package com.maruf.banglaquran;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.provider.ContactsContract;
import android.widget.Toast;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class MyDB extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "Al_Quran1.db";
    private static final int DATABASE_VERSION = 2;

    public MyDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public ArrayList<DataModel> getSurahs() {

        SQLiteDatabase db = getReadableDatabase();
        ArrayList<DataModel> arrayList = new ArrayList<>();
        //
        String sql = "SELECT chptr_no, surah_name, num_verses FROM " + "surah_list";
        Cursor cursor = db.rawQuery(sql, null);
        //
        if (cursor.moveToFirst()) {
            do {
                DataModel dataModel = new DataModel();
                dataModel.setId(cursor.getString(cursor.getColumnIndex("chptr_no")));
                dataModel.setChapter(cursor.getString(cursor.getColumnIndex("chptr_no")));
                dataModel.setSurahName(cursor.getString(cursor.getColumnIndex("surah_name")));
                dataModel.setVerse(cursor.getString(cursor.getColumnIndex("num_verses")));
                arrayList.add(dataModel);
            } while (cursor.moveToNext());
        }
        return arrayList;
    }

    //get ayahs
    public ArrayList<DataModel> getAyahsBySurah(int s_id) {
            SQLiteDatabase db = getReadableDatabase();
            ArrayList<DataModel> arrayList = new ArrayList<>();
            //
            String sql = "SELECT a.verse_id, ArabicAyah, BanglaAyah FROM surah_list s INNER JOIN arabic_ayah a on s.id=a.surah_id INNER JOIN bangla_ayah b on b.id=a.id WHERE s.id"+" = '" + s_id +"'";
            //String sql = "SELECT QuranArabic.VerseID,QuranArabic.AyahText FROM QuranArabic INNER JOIN surah_list ON QuranArabic.SuraID"+" = '" + s_id +"' AND surah_list.id"+"= '"+s_id+"'";
            Cursor cursor = db.rawQuery(sql,null);
            if (cursor.moveToFirst()) {
                do {
                    DataModel dataModel = new DataModel();
                    dataModel.setSurahId(cursor.getString(cursor.getColumnIndex("verse_id")));
                    dataModel.setArabic(cursor.getString(cursor.getColumnIndex("ArabicAyah")));
                    dataModel.setBangla(cursor.getString(cursor.getColumnIndex("BanglaAyah")));
                    arrayList.add(dataModel);
                } while (cursor.moveToNext());
            } else {
                System.out.println("Database is empty");
            }
            return arrayList;
        //
    }
    //get Surah Name
    public String getNameOfSurah(int b_id) {
        SQLiteDatabase db = getReadableDatabase();
        String str = new String();
        //
        String sql = "SELECT surah_name FROM surah_list WHERE id"+" = '" + b_id +"'";
        Cursor cursor = db.rawQuery(sql,null);
        //
        if (cursor.moveToFirst()) {
            do {
                //DataModel dataModel = new DataModel();
                str = cursor.getString(cursor.getColumnIndex("surah_name"));

            } while (cursor.moveToNext());
        } else {
            System.out.println("Database is empty");
        }
        return str;
        //
    }

    //get Bangla ayah
    public String getBanglaAyah(int b_id, int a_id) {
        SQLiteDatabase db = getReadableDatabase();
        String str = new String();
        //
        String sql = "SELECT BanglaAyah FROM bangla_ayah WHERE surah_id"+" = '" + b_id +"' AND verse_id"+" = '" + a_id +"'";
        Cursor cursor = db.rawQuery(sql,null);
        //
        if (cursor.moveToFirst()) {
            do {
                //DataModel dataModel = new DataModel();
                str = cursor.getString(cursor.getColumnIndex("BanglaAyah"));

            } while (cursor.moveToNext());
        } else {
            System.out.println("Database is empty");
        }
        return str;
        //
    }
}
