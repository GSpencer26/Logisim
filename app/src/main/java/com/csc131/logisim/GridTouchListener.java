package com.csc131.logisim;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
class GridTouchListener {

    View view;
    Activity activity;

    GridTouchListener(ImageView v, Activity a){
        view = v;
        activity = a;
    }

    void getGridTouch(final View button){
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == motionEvent.ACTION_DOWN) {
                    MainActivity.gm.createGate(button,motionEvent);
                    view.setOnTouchListener(null);
                    System.out.println("button gridtouch");
                    return true;
                }
                return false;
            }
        });
    }
}
