package com.mahmudulmaruf.cgpaassistant;

//import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Tab1Fragment extends Fragment {
    Button b1, b2;
    TextView a1, a2, a3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);



        //Button functions
        b1 = view.findViewById(R.id.database);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity().getApplicationContext(),UserMain.class);
                startActivity(i);
            }
        });
        b2 = view.findViewById(R.id.btn22);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity().getApplicationContext(),UserInf.class);
                startActivity(i);
            }
        });

        return view;
    }
}
