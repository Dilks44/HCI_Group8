package com.schooldev.group8.travelbuddy;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class EditTrip extends AppCompatActivity {

    private Button mNewItenBtn;
    private Button mContinueBtn;

    private android.support.v7.widget.Toolbar toolbar;


    private TextView mLocName;
    private TextView mLocTime;
    private TextView mLocAddr;
    private TextView mLocName2;
    private TextView mLocTime2;
    private TextView mLocAddr2;
    private boolean isReturned;

    private TextView mStartDateTV;
    private TextView mEndDateTV;
    static final int DATE_DIALOG_ID = 0;
    private int mYear;
    private int mMonth;
    private int mDay;
    static final int DATE_DIALOG_ID2 = 1;
    private int mYear2;
    private int mMonth2;
    private int mDay2;
    private boolean secondRound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Display screen allowing user to add/delete destinations
        setContentView(R.layout.activity_edit_trip);

        TextView tripNameText = (TextView) findViewById(R.id.tripNameTV);
        tripNameText.setText("Fun day with friends!");
        mLocName = (TextView) findViewById(R.id.locNameTextView);
        mLocTime = (TextView) findViewById(R.id.tripTimeTextView);
        mLocAddr = (TextView) findViewById(R.id.tripAddressView);

        mLocName2 = (TextView) findViewById(R.id.locNameTextView2);
        mLocTime2 = (TextView) findViewById(R.id.tripTimeTextView2);
        mLocAddr2 = (TextView) findViewById(R.id.tripAddressView2);


        // Some default display info for the demo
        mLocName.setText("Quai Branly Museum");
        mLocTime.setText("7:00 am - 5:00 pm");
        mLocAddr.setText("37 Quai Branly, 75007 Paris, France");

        mStartDateTV = (TextView) findViewById(R.id.startDateTV);
        mEndDateTV = (TextView) findViewById(R.id.endDateTV);

        mStartDateTV.setText("12-11-2016");
        mStartDateTV.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
            }
        });
        mEndDateTV.setText("12-13-2016");
        mEndDateTV.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID2);
            }
        });


        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar2);
        toolbar.setVisibility(View.INVISIBLE);


        mNewItenBtn = (Button) findViewById(R.id.addNewItin);
        mNewItenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(EditTrip.this, itinerary_details.class);
                startActivityForResult(intent, 1);

            }


        });

        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        mYear2 = c.get(Calendar.YEAR);
        mMonth2 = c.get(Calendar.MONTH);
        mDay2 = c.get(Calendar.DAY_OF_MONTH);




        mContinueBtn = (Button) findViewById(R.id.continueBtn);
        mContinueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }

    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;
            updateDisplay();
        }
    };
    private DatePickerDialog.OnDateSetListener mDateSetListener2 = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            mYear2 = year;
            mMonth2 = monthOfYear;
            mDay2 = dayOfMonth;
            updateDisplay();
        }
    };

    private void updateDisplay() {
        mStartDateTV.setText(new StringBuilder()
                // Month is 0 based so add 1
                .append(mMonth + 1).append("-").append(mDay).append("-")
                .append(mYear).append(" "));

        if (secondRound) {
            mEndDateTV.setText(new StringBuilder()
                    // Month is 0 based so add 1
                    .append(mMonth2 + 1).append("-").append(mDay2).append("-")
                    .append(mYear2).append(" "));
        }
        secondRound = true;
    }

    // Create and return DatePickerDialog
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, mDateSetListener, mYear, mMonth,
                        mDay);
            case DATE_DIALOG_ID2:
                return new DatePickerDialog(this, mDateSetListener2, mYear2, mMonth2,
                        mDay2);
        }
        return null;
    }


    @Override
    protected void onResume() {
        super.onResume();
        // am not using this at the moment
        if (isReturned == true) {
            toolbar.setVisibility(View.VISIBLE);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        // Make sure the request was successful

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                String result = data.getStringExtra("result");
                mLocName2.setText("Eiffel Tower");
                mLocTime2.setText("8:00 am - 6:00 pm");
                mLocAddr2.setText("Champ de Mars, 5 Avenue Anatole France, 75007 Paris, France");
                isReturned = true;
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }

    }

}
