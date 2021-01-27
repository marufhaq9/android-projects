package com.maruf.banglaquran;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Objects;

public class SurahClass extends AppCompatActivity{
    ListView lv;
    Context context;
    TextView startSurah;
    /*ToggleButton buttonFavorite;
    ScaleAnimation scaleAnimation;
    BounceInterpolator bounceInterpolator;*/
    SurahAdapter adapter;
    String name;
    int test_id = 0;
    @Override
    protected void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        if (InitApplication.getInstance().isNightModeEnabled()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        setContentView(R.layout.activity_surahs);
        //
        startSurah = findViewById(R.id.starting);
        //
        final MyDB myDB = new MyDB(this);
        lv = findViewById(R.id.list_view);
        //Actionbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //
        //openSurah();
        //
        Intent intent = getIntent();
        DataModel dataModel = (DataModel) intent.getSerializableExtra("surah_id");
        //assert dataModel != null;

        if (dataModel != null) {
            test_id = Integer.parseInt(dataModel.getId());
        }
        //Toast.makeText(SurahClass.this,"id no is: "+ test_id + ".",Toast.LENGTH_SHORT).show();

        name = myDB.getNameOfSurah(test_id);

        String appName = String.valueOf(R.string.app_name);
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                Objects.requireNonNull(getSupportActionBar()).setTitle(name);
            }
        }catch (NullPointerException exception){
            Log.e(appName,"Received an exception: ",exception);
            return;
        }
        //Settin Bismillah and Aujubillah
        if(test_id==1)
            startSurah.setText(R.string.aujubillajh);
        else
            startSurah.setText(R.string.bismillah);
        //toolbar.setTitle(0);

        //Toast.makeText(getApplicationContext(),name, Toast.LENGTH_SHORT).show();
        //
        ArrayList<DataModel> arrayList = myDB.getAyahsBySurah(test_id);
        //arrayList = myDB.getBanglaAyahs(test_id);
        //
        adapter = new SurahAdapter(arrayList, this);
        lv.setAdapter(adapter);
        //Long press on each item
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
                MenuInflater inflater = popupMenu.getMenuInflater();
                inflater.inflate(R.menu.popup_menu, popupMenu.getMenu());

                final int position = i+1;
                final int surah_id = test_id;

                //
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        int id = menuItem.getItemId();
                        if(id==R.id.bangla_copy){
                            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                            ClipData clip = ClipData.newPlainText("Bangla Qur'an","\""+myDB.getBanglaAyah(surah_id, position)+"\""
                                    +"\n-"+myDB.getNameOfSurah(surah_id)+"\n"
                                    +getApplicationContext().getResources().getString(R.string.verses)
                                    +": "+position);
                            assert clip != null;
                            clipboard.setPrimaryClip(clip);
                            Toast.makeText(getApplicationContext(), "Copied!!", Toast.LENGTH_LONG).show();
                        }
                        if(id==R.id.arabic_copy){
                            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                            ClipData clip = ClipData.newPlainText("Bangla Qur'an","\""+myDB.getBanglaAyah(surah_id, position)+"\""
                                    +"\n-"+myDB.getNameOfSurah(surah_id)+"\n"
                                    +getApplicationContext().getResources().getString(R.string.verses)
                                    +": "+position);
                            assert clip != null;
                            clipboard.setPrimaryClip(clip);
                            Toast.makeText(getApplicationContext(), "Copied!!", Toast.LENGTH_LONG).show();
                        }
                        return true;
                    }
                });

                popupMenu.show();
                return true;
            }
        });
    }
    //
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        //getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }
    //

    //
    public void openSurah() {

            ViewGroup viewGroup = findViewById(android.R.id.content);
            View dialogView = LayoutInflater.from(this).inflate(R.layout.activity_start_surah, viewGroup, false);
            //Now we need an AlertDialog.Builder object
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            //setting the view of the builder to our custom view that we already inflated
            builder.setView(dialogView);
            //AlertDialog
            final AlertDialog dialog = builder.create();
            //Buttons onClick Actions
            Button button1;
            button1 = dialogView.findViewById(R.id.buttonOk);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            builder.setView(dialogView);
            dialog.show();
            //
    }
}
