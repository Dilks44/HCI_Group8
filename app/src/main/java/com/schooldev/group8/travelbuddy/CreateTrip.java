package com.schooldev.group8.travelbuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreateTrip extends AppCompatActivity {

    private Button mNewItenBtn;
    private int RESULT_WITH_DATA = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_trip);

        mNewItenBtn = (Button) findViewById(R.id.addNewItin);
        mNewItenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(CreateTrip.this, itinerary_details.class);
                startActivityForResult(intent, RESULT_WITH_DATA);

            }


        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Make sure the request was successful
        if (resultCode == RESULT_OK) {

            // Check which request we're responding to
            if (requestCode == RESULT_WITH_DATA) {
                // The user is returning info
                // The Intent's data is where we should look for info like location name etc.

                // Do something with the data we have collected.. Specifically add it to the list of
                // current itinerary items
            }
        }
    }
}
