package com.csc131.logisim;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
class GridTouchListener {

    View view;
    Activity activity;
    Grid grid;

    GridTouchListener(ImageView v,Grid g, Activity a){
        view = v;
        activity = a;
        grid = g;
    }

    void getGridTouch(final View button){
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == motionEvent.ACTION_DOWN) {
                    view.setOnTouchListener(null);
                    grid.addGate(Draw.closestBlock(motionEvent.getX()),Draw.closestBlock(motionEvent.getY()));
                    MainActivity.button.unpress();
                    return true;
                }
                return false;
            }
        });
    }
}
