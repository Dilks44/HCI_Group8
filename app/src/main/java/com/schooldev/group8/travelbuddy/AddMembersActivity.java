package com.schooldev.group8.travelbuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SearchView;
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
    private ArrayList<String> addedMembers=new ArrayList<String> ();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Display screen that shows current group member list and allows for adding/interacting with users/user details
        setContentView(R.layout.activity_add_members);

        // When the Back button is clicked, return to the previous screen
        mBackBtn = (ImageButton) findViewById(R.id.backImageButton);
        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }


        });

        TextView mSendBtn = (TextView) findViewById(R.id.temp);
        mSendBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent= new Intent(AddMembersActivity.this, MembersActivity.class);

                // Add members to the member list through the FaceBook, SMS, and Email search bars
                String toAdd = ((SearchView)findViewById(R.id.searchViewFB)).getQuery().toString().trim();
                if(!toAdd.isEmpty() && !toAdd.equals("Search"))
                    addedMembers.add(toAdd);
                toAdd =((SearchView)findViewById(R.id.searchViewSMS)).getQuery().toString().trim();
                if(!toAdd.isEmpty() && !toAdd.equals("Search"))
                    addedMembers.add(toAdd);
                toAdd =((SearchView)findViewById(R.id.searchViewEmail)).getQuery().toString().trim();
                if(!toAdd.isEmpty() && !toAdd.equals("Search"))
                    addedMembers.add(toAdd);


                String[] arrayAddedMembers = null;
                int numMembers = addedMembers.size();

                if(numMembers!=0) {
                    arrayAddedMembers = new String[numMembers];
                    for (int i = 0; i < numMembers; i++) {
                        arrayAddedMembers[i] = addedMembers.get(i);
                    }
                }

                // Set Toast message to let user know that adding a member was successful
                intent.putExtra(ADDED_MEMBERS, arrayAddedMembers);
                Toast.makeText(AddMembersActivity.this, "Invitations Sent!", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }
}
