package com.schooldev.group8.travelbuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class itinerary_details extends AppCompatActivity {

    private Button mDoneBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_details);

        mDoneBtn = (Button) findViewById(R.id.backToMainBtn);
        mDoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(itinerary_details.this, AddMembersActivity.class);
                startActivity(intent);

            }
        });
    }
}
