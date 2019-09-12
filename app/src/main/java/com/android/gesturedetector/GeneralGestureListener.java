package com.android.gesturedetector;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

public class GeneralGestureListener extends GestureDetector.SimpleOnGestureListener {

    private Context context = null;

    public GeneralGestureListener(Context context) {
        this.context = context;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Toast.makeText(context, "Image view on scrolling. ", Toast.LENGTH_LONG).show();
        return true;
    }


    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Toast.makeText(context, "Image view on double tap. ", Toast.LENGTH_LONG).show();
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Toast.makeText(context, "Image view on long press. ", Toast.LENGTH_LONG).show();
    }

    public boolean onDown(MotionEvent e) {

        Toast.makeText(context, "Image view on Down. ", Toast.LENGTH_LONG).show();
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {

        Toast.makeText(context, "Image view on show press. ", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        Toast.makeText(context, "Image view on Single Tap up. ", Toast.LENGTH_LONG).show();
        return true;
    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        Toast.makeText(context, "Image view on Fling. ", Toast.LENGTH_LONG).show();
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        Toast.makeText(context, "Image view on Single Tap Confirmed. ", Toast.LENGTH_LONG).show();
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        Toast.makeText(context, "Image view on double tap evet. ", Toast.LENGTH_LONG).show();
        return true;
    }

}