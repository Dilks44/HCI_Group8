package com.schooldev.group8.travelbuddy;

import android.content.Intent;
import android.graphics.Color;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.TimerTask;

public class MembersActivity extends AppCompatActivity {
    private ArrayAdapter<String> _arrayAdapter;
    private String[] _memberList;
    private int RESULT_WITH_DATA = 1;
    LinearLayout iconSet = new LinearLayout(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            _memberList = savedInstanceState.getStringArray("Members");
        } else {
            _memberList = new String[]{"me", "jen"};
        }

        setContentView(R.layout.activity_members);
        ListView listView = (ListView) findViewById(R.id.memberList);

        iconSet = new LinearLayout(this);
        iconSet.setBackgroundColor(Color.parseColor("#295e11"));


        _arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, _memberList);
        listView.setAdapter(_arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>adapter, View v, int position, long id){
                Object item = adapter.getItemAtPosition(position);

                // TODO: show the little swipe thing at the location for calling/deleting/stuff

            }
        });

        FloatingActionButton addBtn = (FloatingActionButton) findViewById(R.id.addBtn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MembersActivity.this, AddMembersActivity.class);
                startActivityForResult(intent, RESULT_WITH_DATA);
            }
        });
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putStringArray("Members", _memberList);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }
}
