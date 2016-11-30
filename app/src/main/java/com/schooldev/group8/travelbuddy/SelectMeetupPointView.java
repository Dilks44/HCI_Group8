package com.schooldev.group8.travelbuddy;

import android.content.Context;
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

import java.util.Random;

/**
 * TODO: document your custom view class.
 */
public class SelectMeetupPointView extends View {
    private boolean _clicked = false;

    public SelectMeetupPointView(Context context) {
        super(context);
    }

    public SelectMeetupPointView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SelectMeetupPointView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float touchX = motionEvent.getX();
        float touchY = motionEvent.getY();

        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                _clicked = true;

                break;
            case MotionEvent.ACTION_UP:
                if (_clicked) {
                    //add a nice looking pin and trigger Sarah's view
                }

                break;
        }

        invalidate();
        return true;
    }
}
