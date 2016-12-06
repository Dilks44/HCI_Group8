package com.schooldev.group8.travelbuddy;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class SelectMeetupPointActivity extends AppCompatActivity {
    private static boolean meetupPointSet = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_meetup_point);

        SelectMeetupPointView mpv = (SelectMeetupPointView) findViewById(R.id.meetupView);
        ImageView pin = (ImageView) findViewById(R.id.pin);

        mpv.setPin(pin);
    }

    public static boolean getMeetupPointSet() {
        return meetupPointSet;
    }

    public void onClickCancel (View v) {
        GridLayout meetup_toolbar = (GridLayout) findViewById(R.id.meetup_toolbar_layout);
        ImageView pin = (ImageView) findViewById(R.id.pin);

        meetup_toolbar.setVisibility(View.GONE);
        pin.setVisibility(View.GONE);
    }

    public void onClickCheck (View v) {
        GridLayout meetup_toolbar = (GridLayout) findViewById(R.id.meetup_toolbar_layout);

        Toast.makeText(this, "Meetup Location Set", Toast.LENGTH_SHORT).show();
        meetupPointSet = true;

        meetup_toolbar.setVisibility(View.GONE);

        Intent intent = new Intent(SelectMeetupPointActivity.this, MapScreen.class);
        startActivity(intent);
    }
}
