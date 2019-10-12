package com.csc131.logisim;

import android.view.MotionEvent;
import android.view.View;

class GridListener implements View.OnTouchListener {

    public boolean onTouch(View view, MotionEvent motionEvent) {
    if(motionEvent.getAction() == motionEvent.ACTION_DOWN) {
        if(Button.pressed==null){
            GridAction.action(motionEvent);
        }else {
            ButtonAction.action(motionEvent);
        }
        return true;
    }
    return false;
}
}
