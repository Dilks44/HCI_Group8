package com.schooldev.group8.travelbuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Button mCreateTrip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mCreateTrip = (Button) findViewById(R.id.createTrip);
        mCreateTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(MainActivity.this, CreateTrip.class);
                startActivity(intent);

            }
        });

        String test = "This is a tesst";


        String test2 = "omg is this working??";


        //TextView testTextView = (TextView) findViewById(R.id.testTextBox);

        //testTextView.setText(test2);
    }
}
