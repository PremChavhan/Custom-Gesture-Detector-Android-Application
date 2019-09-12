package com.android.gesturedetector;

import android.gesture.Gesture;
import android.gesture.Prediction;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.os.Vibrator;
import android.widget.Toast;

import android.content.Context;
import android.gesture.Gesture;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.widget.Toast;

import java.util.ArrayList;

import static android.content.Context.VIBRATOR_SERVICE;

public class GesturePerformListener implements GestureOverlayView.OnGesturePerformedListener {

    private Context context = null;
    // Recognize the gesture and return prediction list.
    Vibrator myVib;

    private GestureLibrary gLibrary = null;

    public GesturePerformListener(Context context, GestureLibrary gLibrary) {
        this.context = context;
        this.gLibrary = gLibrary;

    }

    @Override
    public void onGesturePerformed(GestureOverlayView gestureOverlayView, Gesture gesture) {
        myVib = (Vibrator) context.getSystemService(VIBRATOR_SERVICE);
        ArrayList<Prediction> predictions =
                gLibrary.recognize(gesture);

        if (predictions.size() > 0 && predictions.get(0).score > 1.0) {

            String action = predictions.get(0).name;

            Toast.makeText(context, action, Toast.LENGTH_SHORT).show();
            myVib.vibrate(200);
        }

        else
        {
            myVib.vibrate(50);
            Toast.makeText(context,"Action Not Found...", Toast.LENGTH_SHORT).show();
            myVib.vibrate(200);
        }
    }
}