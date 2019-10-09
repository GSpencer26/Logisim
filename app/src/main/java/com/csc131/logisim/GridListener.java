package com.csc131.logisim;

import android.view.MotionEvent;
import android.view.View;

class GridListener implements View.OnTouchListener {

    public boolean onTouch(View view, MotionEvent motionEvent) {
    if(motionEvent.getAction() == motionEvent.ACTION_DOWN && Button.pressed!=null) {
        new ButtonAction(motionEvent);
        return true;
    }
    return false;
}
}
