package com.mahmudulmaruf.cgpaassistant;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Tab2Fragment extends Fragment {
    Activity activity = getActivity();
    Button addG;
    TextView cgpa, crs1, gpa1, crdt1;
    EditText gpa, crdt;
    Double Showgpa=0.0, gp, cr, getGpa, crdts=0.0;
    int i=0;
    String[] str1 , str2 =new String[50];
    DecimalFormat df = new DecimalFormat("0.0000");
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);


        gpa = view.findViewById(R.id.gpa2);
        crdt = view.findViewById(R.id.credit);

        //
        crs1 = view.findViewById(R.id.courseID);
        //gpa1 = view.findViewById(R.id.coursegpa);
        //crdt1 = view.findViewById(R.id.coursecrdt);
        //
        cgpa = view.findViewById(R.id.dispGpa);
        //
        addG = view.findViewById(R.id.add);
        addG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(gpa.getText().toString().matches("")||crdt.getText().toString().matches(""))
                    Toast.makeText(getActivity().getApplicationContext(),"Fill the forms first",Toast.LENGTH_SHORT).show();
                else {
                    gp = Double.parseDouble(gpa.getText().toString());
                    cr = Double.parseDouble(crdt.getText().toString());
                    crdts += cr;
                    getGpa = (gp * cr);
                    Showgpa += getGpa;
                    Double finalGpa = Showgpa/crdts;
                    String format = df.format(finalGpa);

                    //cgpa.setText(Double.toString(Showgpa / crdts));
                    cgpa.setText(format);
                    gpa.setText("");
                    crdt.setText("");
                    i++;
                        crs1.setText("Course: " + i + "      GPA: " + Double.toString(gp) + "      Credit: " + Double.toString(cr) + "\n");
                }
            }
        });

        //crs1.setText("Course: " + i + "      GPA: " + Double.toString(gp) + "      Credit: " + Double.toString(cr) + "\n");
        return view;
    }
}
