package com.maruf.banglaquran;

import android.app.Activity;
import android.content.Context;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class TestAdapter extends ArrayAdapter<TestModel> {
    private ArrayList<TestModel> mDataset;
    Context context;

    public TestAdapter(ArrayList<TestModel> dataModels, Context con) {
        super(con, R.layout.surah_row, dataModels);
        this.mDataset = dataModels;
        this.context = con;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            //.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.surah_row, null, true);

            holder.surahName = convertView.findViewById(R.id.item_title);
            holder.chptrNo = convertView.findViewById(R.id.item_detail);
            holder.vrsNo = convertView.findViewById(R.id.verseNo);
            convertView.setTag(holder);
        } else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder) convertView.getTag();
        }
        holder.surahName.setText(mDataset.get(position).getName());
        holder.chptrNo.setText(mDataset.get(position).getCollege());
        holder.vrsNo.setText(mDataset.get(position).getPhone());
        return convertView;
    }
    private class ViewHolder {
        protected TextView surahName, chptrNo, vrsNo;
        protected ImageView imageView;
    }
}