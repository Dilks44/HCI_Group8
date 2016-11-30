package com.schooldev.group8.travelbuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MapScreen extends AppCompatActivity {

    private Button mBackBtn;
    private Button mSetDestinationBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_screen);


        mBackBtn = (Button) findViewById(R.id.backToMainBtn);
        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MapScreen.this, MainActivity.class);
                startActivity(intent);

            }
        });


        mSetDestinationBtn = (Button) findViewById(R.id.setMeetup);
        mSetDestinationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent intent = new Intent(MapScreen.this, CHANGE );
                //startActivity(intent);

            }
        });



    }
}
