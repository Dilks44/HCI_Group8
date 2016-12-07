package com.schooldev.group8.travelbuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Button mCreateTrip;
    private Button mViewMapBtn;
    private Button mSignOut;


    private TextView textViewTemp;
    private GridLayout mGridLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        mGridLayout = (GridLayout) findViewById(R.id.gridLayout);
        textViewTemp = (TextView) findViewById(R.id.textViewTemp);


        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            textViewTemp.setText("");
            mGridLayout.setVisibility(View.VISIBLE);
        }
        else {
            textViewTemp.setText("Currently no trips. Select create new trip!");
            mGridLayout.setVisibility(View.INVISIBLE);
        }


        mCreateTrip = (Button) findViewById(R.id.createTrip);
        mCreateTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(MainActivity.this, CreateTrip.class);
                startActivity(intent);

            }
        });

        mViewMapBtn = (Button) findViewById(R.id.viewMap);
        mViewMapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(MainActivity.this, MapScreen.class);
                startActivity(intent);

            }
        });

        mSignOut = (Button) findViewById(R.id.signOut);
        mSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO - We may need an alternative for this. Looks like only kills current stack not whole app.
                System.exit(0);

            }
        });

    }


}
