package com.schooldev.group8.travelbuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddMembersActivity extends AppCompatActivity {
    public final static String ADDED_MEMBERS = "com.example.myfirstapp.ADDED_MEMBERS";
    private ImageButton mBackBtn;
    private Button tempBackBtn;
    private Button tempForwardBtn;
    private ArrayList<String> addedMembers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_members);

        tempBackBtn = (Button) findViewById(R.id.tempBackBtn);
        tempBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddMembersActivity.this, "New Trip Created!!", Toast.LENGTH_SHORT).show();
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

        TextView mSendBtn = (TextView) findViewById(R.id.temp);
        mSendBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent= new Intent(AddMembersActivity.this, MembersActivity.class);

                String toAdd = ((SearchView)findViewById(R.id.searchViewFB)).getQuery().toString().trim();
                if(!toAdd.isEmpty() && !toAdd.equals("Search"))
                    addedMembers.add(toAdd);
                toAdd =((SearchView)findViewById(R.id.searchViewSMS)).getQuery().toString().trim();
                if(!toAdd.isEmpty() && !toAdd.equals("Search"))
                    addedMembers.add(toAdd);
                toAdd =((SearchView)findViewById(R.id.searchViewEmail)).getQuery().toString().trim();
                if(!toAdd.isEmpty() && !toAdd.equals("Search"))
                    addedMembers.add(toAdd);

                int numMembers = addedMembers.size();
                String[] arrayAddedMembers = new String[numMembers];
                for (int i=0; i<numMembers; i++) {
                    arrayAddedMembers[i] = addedMembers.get(i);
                }

                intent.putExtra(ADDED_MEMBERS, addedMembers);
                startActivity(intent);
            }
        });
    }
}
