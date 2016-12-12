package com.schooldev.group8.travelbuddy;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class itinerary_details extends AppCompatActivity {

    private Button mDoneBtn;
    private Button mPopulateBtn;
    private int RESULT_WITH_DATA = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_details);


        mDoneBtn = (Button) findViewById(R.id.returnResultData);
        mDoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent intent = new Intent(itinerary_details.this, CreateTrip.class);
                //startActivity(intent);
                Intent returnIntent = new Intent();
                String result = "hello";
                returnIntent.putExtra("result",result);
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });

        mPopulateBtn = (Button) findViewById(R.id.launchMapsBtn);
        mPopulateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView locName = (TextView) findViewById(R.id.locationNameData);
                locName.setText("Eiffel Tower");

                TextView address = (TextView) findViewById(R.id.addressData);
                address.setText("Champ de Mars, 5 Avenue Anatole France, 75007 Paris, France");
                TextView startHrs = (TextView) findViewById(R.id.startHours);
                startHrs.setText("8:00am");
                TextView endHrs = (TextView) findViewById(R.id.endHours);
                endHrs.setText("6:00pm");


            }
        });
    }
}
