package com.schooldev.group8.travelbuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Member;

public class MapScreen extends AppCompatActivity {

    private Button mBackBtn;
    private Button mSetDestinationBtn;
    private Button mFriendsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_screen);

        // Back BTN
        mBackBtn = (Button) findViewById(R.id.backToMainBtn);
        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Friends BTN
        mFriendsBtn = (Button) findViewById(R.id.friendsBtn);
        mFriendsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapScreen.this, MembersActivity.class );
                startActivity(intent);
            }
        });



        // Meetup Location BTN
        mSetDestinationBtn = (Button) findViewById(R.id.setMeetup);
        mSetDestinationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MapScreen.this, SelectMeetupPointActivity.class );
                startActivity(intent);

            }
        });



    }
}
