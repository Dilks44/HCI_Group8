package com.schooldev.group8.travelbuddy;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CreateTrip extends AppCompatActivity {

    private Button mNewItenBtn;
    private Button mContinueBtn;


    private TextView mLocName;
    private TextView mLocTime;
    private TextView mLocAddr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_trip);


        mLocName = (TextView) findViewById(R.id.locNameTextView);
        mLocTime = (TextView) findViewById(R.id.tripTimeTextView);
        mLocAddr = (TextView) findViewById(R.id.tripAddressView);


        mNewItenBtn = (Button) findViewById(R.id.addNewItin);
        mNewItenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(CreateTrip.this, itinerary_details.class);
                startActivityForResult(intent, 1);

            }


        });




        mContinueBtn = (Button) findViewById(R.id.continueBtn);
        mContinueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(CreateTrip.this, AddMembersActivity.class);
                startActivity(intent);
            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();
        // am not using this at the moment

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        // Make sure the request was successful

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                String result = data.getStringExtra("result");
                mLocName.setText("Eiffel Tower");
                mLocTime.setText("8:00 am - 6:00 pm");
                mLocAddr.setText("Champ de Mars, 5 Avenue Anatole France, 75007 Paris, France");
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }

    }

}
