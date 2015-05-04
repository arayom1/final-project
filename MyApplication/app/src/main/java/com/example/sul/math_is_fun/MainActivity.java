package com.example.sul.math_is_fun;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseException;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

//import java.text.ParseException;
import java.util.List;

public class MainActivity extends Activity {

    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "nobpmtodoIdRkOYG18wbRxvwU8S9WQVQH2zXr4ZZ", "3Y8SNpYVdDMwmjgqCFc26yyrt51OPVBfq07ZPkIb");
//        query.findInBackground(new FindCallback<ExamParse>() {
//            public void done(List<ExamParse> scoreList, ParseException e) {
//                if (e == null) {
//                    Log.d("score", "Retrieved " + scoreList.size() + " scores");
//                } else {
//                    Log.d("score", "Error: " + e.getMessage());
//                }
//            }
//        });
        // Fragment transaction for our Fragment -- very simple
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new RecyclerViewFragment())
                        // Don't forget this nice little animation!
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();

        addButton = (Button) findViewById(R.id.mybutton);


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getIntent = new Intent(MainActivity.this, AddingActivity.class);
                MainActivity.this.startActivity(getIntent);
            }
        });
    }
}