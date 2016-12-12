package com.schooldev.group8.travelbuddy;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SelectMeetupPointActivity extends AppCompatActivity {
    private static boolean meetupPointSet = false;

    // Notification ID to allow for future updates
    private static final int MY_NOTIFICATION_ID = 1;

    // Notification Count
    private int mNotificationCount;

    // Notification Text Elements
    private final CharSequence tickerText = "A Friend is trying to meet up!";
    private final CharSequence contentTitle = "TravelBuddy";
    private final CharSequence contentText = "Tom has set a meetup location!";

    // Notification Action Elements
    private Intent mNotificationIntent;
    private PendingIntent mContentIntent;

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

        mNotificationIntent = new Intent(getApplicationContext(),  MapScreen.class);
        mContentIntent = PendingIntent.getActivity(getApplicationContext(), 0,
                mNotificationIntent, PendingIntent.FLAG_ONE_SHOT);

        Notification.Builder notificationBuilder = new Notification.Builder(
                getApplicationContext())
                .setTicker(tickerText)
                .setSmallIcon(android.R.drawable.stat_sys_warning)
                .setContentTitle(contentTitle)
                .setContentText(contentText)
                .setContentIntent(mContentIntent);

        // Pass the Notification to the NotificationManager:
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(MY_NOTIFICATION_ID, notificationBuilder.build());


        Intent intent = new Intent(SelectMeetupPointActivity.this, MapScreen.class);
        startActivity(intent);
    }
}
