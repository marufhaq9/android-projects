package com.mahmudulmaruf.cgpaassistant;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class GpaCalcy extends AppCompatActivity {

    //RelativeLayout container;
    Button addG;
    TextView cgpa, crs1, gpa1, crdt1;
    EditText gpa, crdt;
    Double Showgpa=0.0, gp, cr, getGpa, crdts=0.0;
    int i=0;
    String[] str1 , str2 =new String[50];
    DecimalFormat df = new DecimalFormat("0.0000");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_two);

        //

        //
        gpa = findViewById(R.id.gpa2);
        crdt = findViewById(R.id.credit);

        //
        crs1 = findViewById(R.id.courseID);
        //gpa1 = findViewById(R.id.coursegpa);
        //crdt1 = findViewById(R.id.coursecrdt);
        //
        cgpa = findViewById(R.id.dispGpa);
        //
        addG = findViewById(R.id.add);
        addG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(gpa.getText().toString().matches("")||crdt.getText().toString().matches(""))
                    Toast.makeText(GpaCalcy.this,"Fill the forms first",Toast.LENGTH_SHORT).show();
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
                    //str1[i]=Double.toString(gp);
                    //str2[i]=Double.toString(cr);
                    crs1.setText("Course: " + i + "      GPA: " + Double.toString(gp) + "      Credit: " + Double.toString(cr) + "\n");
                    //crs1.setText(multi);
                        //gpa1.setText("GPA: " + Double.toString(gp));
                        //crdt1.setText("Credit:" + Double.toString(cr));
                    //}
                }
            }
        });

            //crs1.setText("Course: " + i + "      GPA: " + Double.toString(gp) + "      Credit: " + Double.toString(cr) + "\n");
    }

}
