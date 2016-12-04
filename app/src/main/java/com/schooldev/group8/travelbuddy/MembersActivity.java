package com.schooldev.group8.travelbuddy;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MembersActivity extends AppCompatActivity {
    private ArrayAdapter<String> _arrayAdapter;
    private String[] _memberList;
    private int RESULT_WITH_DATA = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            _memberList = savedInstanceState.getStringArray("Members");
        } else {
            _memberList = new String[]{"me"};
        }

        setContentView(R.layout.activity_members);
        ListView listView = (ListView) findViewById(R.id.memberList);

        _arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, _memberList);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>adapter, View v, int position, long id){
                Object item = adapter.getItemAtPosition(position);

                //TODO: show the little swipe thing at the location for calling/deleting/stuff.
            }
        });

        Button addBtn = (Button) findViewById(R.id.addBtn);

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
