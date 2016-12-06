package com.schooldev.group8.travelbuddy;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TimerTask;

public class MembersActivity extends AppCompatActivity {
    private ArrayAdapter<String> _arrayAdapter;
    private static ArrayList<String> _memberList;
    private int RESULT_WITH_DATA = 1;
    private Animation slideInRight;
    private Animation slideOutRight;
    private boolean menuActive = false;
    private LinearLayout iconSet;
    private int _activeMember = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_members);

        // Set up animations on the little icon menu
        iconSet = (LinearLayout) findViewById(R.id.iconSet);
        slideInRight = AnimationUtils.loadAnimation(this, R.anim.slideinright);
        slideOutRight = AnimationUtils.loadAnimation(this, R.anim.slideoutright);

        //get past members
        if (_memberList == null) {
            _memberList = new ArrayList<String>();
            _memberList.add("Me");
            _memberList.add("Jen");
        }

        //add any new members
        Intent intent = getIntent();
        String[] newMembers = intent.getStringArrayExtra(AddMembersActivity.ADDED_MEMBERS);

        if(newMembers != null) {
            _memberList.addAll(Arrays.asList(newMembers));
        }

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
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) iconSet.getLayoutParams();
                params.height = v.getHeight();
                params.topMargin=v.getTop();
                iconSet.setLayoutParams(params);
                iconSet.setVisibility(View.VISIBLE);
                iconSet.startAnimation(slideInRight);
                _activeMember=position;
            }
        });

        ImageView backIcon = (ImageView) findViewById(R.id.backIcon);
        ImageView phoneIcon = (ImageView) findViewById(R.id.phoneIcon);
        ImageView messageIcon = (ImageView) findViewById(R.id.messageIcon);
        ImageView deleteIcon = (ImageView) findViewById(R.id.deleteIcon);

        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iconSet.startAnimation(slideOutRight);
                iconSet.setVisibility(View.INVISIBLE);
                menuActive=false;
            }
        });

        deleteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder adb=new AlertDialog.Builder(MembersActivity.this);
                adb.setTitle("Delete?");
                adb.setMessage("Are you sure you want to delete " + _memberList.get(_activeMember));
                adb.setNegativeButton("Cancel", null);
                adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        _memberList.remove(_activeMember);
                        _arrayAdapter.notifyDataSetChanged();
                    }});
                adb.show();

                iconSet.startAnimation(slideOutRight);
                iconSet.setVisibility(View.INVISIBLE);
                menuActive=false;
            }
        });

        iconSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iconSet.startAnimation(slideOutRight);
                iconSet.setVisibility(View.INVISIBLE);
                menuActive=false;
            }
        });

        FloatingActionButton addBtn = (FloatingActionButton) findViewById(R.id.addBtn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MembersActivity.this, AddMembersActivity.class);
                startActivity(intent);
            }
        });

        Button doneBtn = (Button) findViewById(R.id.nextBtn);
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MembersActivity.this, MapScreen.class);
                startActivity(intent);
            }
        });
    }

//    public void onSaveInstanceState(Bundle savedInstanceState) {
//        // Save the user's current game state
//        savedInstanceState.putStringArrayList("Members", _memberList);
//
//        // Always call the superclass so it can save the view hierarchy state
//        super.onSaveInstanceState(savedInstanceState);
//    }
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
