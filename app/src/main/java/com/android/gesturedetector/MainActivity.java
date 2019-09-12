package com.android.gesturedetector;

import android.annotation.SuppressLint;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.os.Bundle;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Gesture Detector");

        addGesturePerformListener();

        addGeneralGestureListener();
    }


    /*
     *  Use GestureOverlayView to detect custom gesture saved in gesture library. */
    @SuppressLint("ClickableViewAccessibility")
    private void addGesturePerformListener()
    {
        // Get the GestureOverlayView widget object.
        final GestureOverlayView gestureOverlayView = (GestureOverlayView)findViewById(R.id.custom_gesture_overlay_view);

        // Build the custom gesture library with gesture builder created file.
        GestureLibrary gestureLibrary = GestureLibraries.fromRawResource(getApplicationContext(), R.raw.gesture);
        // Load custom gestures into library.
        gestureLibrary.load();

        // Create an instance of custom gesture listener.
        GesturePerformListener myGestureListener = new GesturePerformListener(getApplicationContext(), gestureLibrary);

        // Add custom gesture listener instance to gesture overlay view to listen custom gesture.
        gestureOverlayView.addOnGesturePerformedListener(myGestureListener);

        // You can also set an on touch listener to the gesture overlay view to listen to on touch event.
        gestureOverlayView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                //Toast.makeText(getApplicationContext(), "Gesture overlay view on touch event occured.", Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }


    /* Use GestureDetectorCompat to detect general gesture take place on the image view. */
    private void addGeneralGestureListener()
    {

        //ImageView imageView = (ImageView)findViewById(R.id.general_gesture_imageview);

        // This gesture listener is used with the image view.
        GeneralGestureListener imageViewGestureListener = new GeneralGestureListener(getApplicationContext());

        // Create image view gesture detector.
        final GestureDetectorCompat imageViewGestureDetectorCompat = new GestureDetectorCompat(this, imageViewGestureListener);

        // Set double tap listener.
        imageViewGestureDetectorCompat.setOnDoubleTapListener(imageViewGestureListener);

        // Set a new OnTouchListener to image view.
        //  imageView.setOnTouchListener(new View.OnTouchListener() {
           // @Override
            //public boolean onTouch(View view, MotionEvent motionEvent) {
                // When image view ontouch event occurred, call it's gesture detector's onTouchEvent method.
              //  imageViewGestureDetectorCompat.onTouchEvent(motionEvent);
                // Return true to tell android OS this listener has consumed the event, do not need to pass the event to other listeners.
                //return true;
            }
        //});
    }
