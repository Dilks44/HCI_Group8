package com.schooldev.group8.travelbuddy;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class itinerary_details extends AppCompatActivity {

    private Button mDoneBtn;
    private Button mPopulateBtn;
    private int RESULT_WITH_DATA = 1;
    private static EditText arrivalTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_details);

        // done button - goes back to itinerary page
        mDoneBtn = (Button) findViewById(R.id.returnResultData);
        mDoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                String result = "hello";
                returnIntent.putExtra("result",result);
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });

        // populate the fields in iterary page - currently hardcoded
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

        //allow user to pick using a clock for arrival time.
        arrivalTime = (EditText) findViewById(R.id.arrivalTimeData);
        arrivalTime.setInputType(InputType.TYPE_NULL); //not to be confused with the pokemon ;__;

        arrivalTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment timePick = new TimePickerFragment();
                timePick.show(getFragmentManager(), "timePicker");
            }
        });

        // put in a number for duration
        EditText duration = (EditText) findViewById(R.id.durationTimeData);
        duration.setInputType(InputType.TYPE_CLASS_NUMBER);
    }

    // from android picker documentation
    public static class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {
        EditText toPopulate;

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        @RequiresApi(api = Build.VERSION_CODES.N)

        //formats the numbers properly and populates the edit area with the string.
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            String period = "AM";
            DecimalFormat formatter = new DecimalFormat("00");

            if (hourOfDay > 12) {
                period = "PM";
                hourOfDay -= 12;
            } else if (hourOfDay == 0) {
                hourOfDay = 12;
            }
            String hour = formatter.format(hourOfDay);
            String min = formatter.format(minute);

            String time = hour + ":" + min + ' ' + period;

            arrivalTime.setText(time);
        }
    }
}
