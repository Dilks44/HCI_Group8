package com.schooldev.group8.travelbuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String test = "This is a tesst";


        String test2 = "omg is this working??";


        TextView testTextView = (TextView) findViewById(R.id.testTextBox);

        testTextView.setText(test2);
    }
}
