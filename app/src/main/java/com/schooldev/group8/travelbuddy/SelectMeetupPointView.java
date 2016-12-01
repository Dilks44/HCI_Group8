package com.schooldev.group8.travelbuddy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;

/**
 * TODO: document your custom view class.
 */
public class SelectMeetupPointView extends View {
    private boolean _clicked = false;
    private ImageView _pin;

    public SelectMeetupPointView(Context context) {
        super(context);
    }

    public SelectMeetupPointView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SelectMeetupPointView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setPin(ImageView pin) {
        _pin = pin;
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int touchX = (int) motionEvent.getX();
        int touchY = (int) motionEvent.getY();

        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                _clicked = true;

                break;
            case MotionEvent.ACTION_UP:
                if (_clicked) {
                    RelativeLayout.LayoutParams layoutParams=new RelativeLayout.LayoutParams(50, 100);
                    layoutParams.setMargins(touchX-25, touchY-100, 0, 0);
                    _pin.setLayoutParams(layoutParams);
                    _pin.setVisibility(View.VISIBLE);

                    GridLayout meetup_toolbar = (GridLayout) ((Activity) getContext()).findViewById(R.id.meetup_toolbar_layout);

                    if (meetup_toolbar != null) {
                        meetup_toolbar.setVisibility(VISIBLE);
                    }

                    _clicked = false;
                }

                break;
        }

        invalidate();
        return true;
    }
}
