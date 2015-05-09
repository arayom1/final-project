
package com.example.sul.exam_shedules;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseObject;


public class AddingActivity extends ActionBarActivity {

    Button Done_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding);

        EditText name = (EditText) findViewById(R.id.ET_name);
        EditText date = (EditText) findViewById(R.id.ET_date);
        EditText time = (EditText) findViewById(R.id.ET_time);
        EditText classroom = (EditText) findViewById(R.id.ET_classroom);

        Done_Button = (Button) findViewById(R.id.BT_Done);

        Done_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = (EditText) AddingActivity.this.findViewById(R.id.ET_name);
                EditText date = (EditText) AddingActivity.this.findViewById(R.id.ET_date);
                EditText time = (EditText) AddingActivity.this.findViewById(R.id.ET_time);
                EditText classroom = (EditText) AddingActivity.this.findViewById(R.id.ET_classroom);

                String aname = name.getText().toString();
                String adate = date.getText().toString();
                String atime = time.getText().toString();
                String aclassroom = classroom.getText().toString();


                ParseObject examObject = new ParseObject("ExamObject");
                examObject.put("name", aname);
                examObject.put("date", adate);
                examObject.put("time", atime);
                examObject.put("classroom", aclassroom);
                examObject.saveInBackground();
            }
        });


    }
}