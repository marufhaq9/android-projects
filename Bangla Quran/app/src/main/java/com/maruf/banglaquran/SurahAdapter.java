package com.maruf.banglaquran;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class SurahAdapter extends ArrayAdapter<DataModel> {
    private ArrayList<DataModel> mDataset;
    Context context;
    Typeface typeface;

    public String getFFont(){
        String retnm;
        SettingsClass settingsClass = new SettingsClass();
        String nm = settingsClass.getFfont();
        if(nm=="saleem"){
            retnm = nm;
        }
        else if(nm=="medina"){
            retnm=nm;
        }
        else{
            retnm = nm;
        }
        return retnm;
    }

    public SurahAdapter(ArrayList<DataModel> dataModels, Context con) {
        super(con, R.layout.ayah_row, dataModels);
        this.mDataset = dataModels;
        this.context = con;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String s;
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            //.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.card_layout, null, true);

            holder.surahName = convertView.findViewById(R.id.item_ayah);
            holder.chptrNo = convertView.findViewById(R.id.item_title);
            holder.vrsNo = convertView.findViewById(R.id.item_detail);
            convertView.setTag(holder);
        } else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder) convertView.getTag();
        }
        holder.surahName.setText("﴾"+mDataset.get(position).getSurahId()+"﴿");
        //holder.chptrNo.setTypeface(Typeface.createFromFile("font/medina.ttf"));
        holder.chptrNo.setText(mDataset.get(position).getArabic());
        holder.vrsNo.setText(mDataset.get(position).getBangla());
        return convertView;
    }
    private class ViewHolder {
        protected TextView surahName, chptrNo, vrsNo;
        String getFont;
        //Typeface tp;
        //protected ImageView imageView;
    }
}