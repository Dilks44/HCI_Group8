package com.schooldev.group8.travelbuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Button mCreateTrip;
    private Button mViewMapBtn;
    private Button mSignOut;


    private TextView textViewTemp;
    private GridLayout mGridLayout;

    private ImageButton mImageBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mGridLayout = (GridLayout) findViewById(R.id.gridLayout);
        textViewTemp = (TextView) findViewById(R.id.textViewTemp);

        //check for trips that are already saved
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            textViewTemp.setText("");
            mGridLayout.setVisibility(View.VISIBLE);
        }
        else {
            textViewTemp.setText("Currently no trips. Select create new trip!");
            mGridLayout.setVisibility(View.INVISIBLE);
        }

        // create new trip button
        mCreateTrip = (Button) findViewById(R.id.createTrip);
        mCreateTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(MainActivity.this, CreateTrip.class);
                startActivity(intent);

            }
        });

        //clicking a previous trip
        mViewMapBtn = (Button) findViewById(R.id.viewMap);
        mViewMapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(MainActivity.this, MapScreen.class);
                startActivity(intent);

            }
        });

        //sign out - not really needed rn
        mSignOut = (Button) findViewById(R.id.signOut);
        mSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO - We may need an alternative for this. Looks like only kills current stack not whole app.
                System.exit(0);

            }
        });

        // button that edits the trip
        mImageBtn = (ImageButton) findViewById(R.id.editItineraryBtn);
        mImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, EditTrip.class);
                startActivity(intent);
            }
        });
    }


}
