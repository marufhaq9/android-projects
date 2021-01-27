package com.maruf.banglaquran;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;

public class QuranClass extends AppCompatActivity {
    ListView lv;
    private CustomAdapter adapter;
    private ArrayList<DataModel> arrayList;
    private MyDB myDB;
    //private Cursor surahs;
    Context context;

    @Override
    protected void onCreate(Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_quran);


        //test db
        /*myDB = new MyDB(this);
        lv = findViewById(R.id.list_view);
        arrayList = myDB.getAll();
        mAdapter = new TestAdapter(arrayList, this);
        lv.setAdapter(mAdapter);*/
        /*myDB = new MyDB(this);*/
        myDB = new MyDB(this);
        lv = findViewById(R.id.list_view);
        arrayList = myDB.getSurahs();

        adapter = new CustomAdapter(arrayList, this);
        DataModel model = new DataModel();
        lv.setAdapter(adapter);
        //
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(QuranClass.this,SurahClass.class);
                intent.putExtra("surah_id", (Serializable) arrayList.get(i));
                startActivity(intent);
                //finish();
            }
        });
    }
}
