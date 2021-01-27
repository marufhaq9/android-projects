package com.mahmudulmaruf.cgpaassistant;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainDialog extends Activity{
    final Context context = this;
    //private Button buttonAccept, buttonExit;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gpa_fastcalc);

        //buttonAccept = (Button)findViewById(R.id.dialogAccept);
        //buttonExit = (Button) findViewById(R.id.dialogExit);

                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.activity_dialog1);
                dialog.setTitle("Hello Student!!");

                // set the custom dialog components - text, image and button
                TextView text = dialog.findViewById(R.id.text);
                text.setText("Android custom dialog example!");
                ImageView image = dialog.findViewById(R.id.image);
                image.setImageResource(R.drawable.ic_stdnt);
                //Dialog Accept
        Button dialogButton = findViewById(R.id.dialogAccept);
        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                //Intent i = new Intent(getApplicationContext(),MainActivity.class);
                //startActivity(new Intent(MainDialog.this, MainActivity.class));
                //startActivity(i);
                //finish();
            }
        });
        //Dialog Exit
        Button dialogExit = findViewById(R.id.dialogExit);
        dialogExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }

}
