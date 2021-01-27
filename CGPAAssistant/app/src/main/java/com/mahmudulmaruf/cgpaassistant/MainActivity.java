package com.mahmudulmaruf.cgpaassistant;

//import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    //final Context this;
    Button buttonf, calculate, saved, ttab;
    EditText uName, uVarsity, uCourse;

    String name, institute, courses;
    Integer courseNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mTopToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(mTopToolbar);

        uName = findViewById(R.id.inputName);
        uVarsity = findViewById(R.id.inputInstitute);
        uCourse = findViewById(R.id.courseNo);

        ttab=findViewById(R.id.button2);

        name = uName.getText().toString();
        institute = uVarsity.getText().toString();
        courses = uCourse.getText().toString();
        //courseNo = Integer.parseInt(uCourse.getText().toString());

        calculate = findViewById(R.id.gpaResult);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(courses==null || courses.length()==0){
                    Toast.makeText(MainActivity.this, "Fill the Form first", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent in = new Intent(getApplicationContext(),GpaCalcy.class);
                    in.putExtra("uName", name);
                    in.putExtra("uVarsity", institute);
                    in.putExtra("uCourse", courses);
                    startActivity(in);
                    finish();
                }
            }
        });

        //calcButton();*/

        buttonf = findViewById(R.id.button);
        buttonf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, GpaCalcy.class);
                startActivity(i);
                finish();
            }
        });

        saved = findViewById(R.id.buttonsave);
        saved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SavedResults.class);
                startActivity(i);
                finish();
            }
        });
        ttab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, TabActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_favorite) {
            Toast.makeText(MainActivity.this, "Action clicked", Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //public void calcButton(){

    //}
}
