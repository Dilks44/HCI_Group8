package com.schooldev.group8.travelbuddy;

import android.content.Intent;
import android.graphics.Color;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
    private Animation slideInRight;
    private Animation slideOutRight;
    private boolean menuActive = false;
    private LinearLayout iconSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Set up animations on the little icon menu
        iconSet = (LinearLayout) findViewById(R.id.iconSet);
        slideInRight = AnimationUtils.loadAnimation(this, R.anim.slideinright);
        slideOutRight = AnimationUtils.loadAnimation(this, R.anim.slideoutright);

        //get past members
        if (savedInstanceState != null) {
            _memberList = savedInstanceState.getStringArray("Members");
        } else {
            _memberList = new String[]{"me", "jen"};
        }

        //add any new members
        Intent intent = getIntent();
        String[] newMembers = intent.getStringArrayExtra(AddMembersActivity.ADDED_MEMBERS);

        if (newMembers != null) {
            String[] allAdded = new String[_memberList.length + newMembers.length];
            int i = 0;

            for (i = 0; i < _memberList.length; i++) {
                allAdded[i] = _memberList[i];
            }

            for (int j = 0; j < newMembers.length; j++) {
                allAdded[i] = newMembers[j];
                i++;
            }
        }

        setContentView(R.layout.activity_members);
        ListView listView = (ListView) findViewById(R.id.memberList);

        _arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, _memberList);
        listView.setAdapter(_arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>adapter, View v, int position, long id){
                Object item = adapter.getItemAtPosition(position);

                if (menuActive) {
                    iconSet.startAnimation(slideOutRight);
                    iconSet.setVisibility(View.INVISIBLE);
                }

                iconSet.setTop(v.getTop());
                iconSet.setVisibility(View.VISIBLE);
                iconSet.startAnimation(slideInRight);
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

//class AnimationTask extends TimerTask {
//    MembersActivity _membersActivity;
//    int _stepSize = 5;
//    float _stepSizePerSecond = 300;
//
//    public AnimationTask(MembersActivity membersActivity) {
//        _membersActivity = membersActivity;
//    }
//
//    @Override
//    public void run() {
//        _animationView._xBallLocation += _stepSize;
//
//        if(_animationView._xBallLocation >= _animationView.getWidth() - _animationView._ballRadius) {
//            _stepSize = -1 * _stepSize;
//        } else if (_animationView._xBallLocation - _animationView._ballRadius <= 0) {
//            _stepSize = -1 * _stepSize;
//        }
//
//        _animationView.postInvalidate();
//    }
//}
