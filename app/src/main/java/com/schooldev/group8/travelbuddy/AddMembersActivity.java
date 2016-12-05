package com.schooldev.group8.travelbuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class AddMembersActivity extends AppCompatActivity {
    private ImageButton mBackBtn;
    private Button tempBackBtn;
    private Button tempForwardBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_members);

        tempBackBtn = (Button) findViewById(R.id.tempBackBtn);
        tempBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

        tempForwardBtn = (Button) findViewById(R.id.tempForward);
        tempForwardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(AddMembersActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });


        // TODO - Can you actually click on toolbars? Because its not working right now..
        mBackBtn = (ImageButton) findViewById(R.id.backImageButton);
        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishActivity(RESULT_CANCELED);

            }


        });
    }
}
