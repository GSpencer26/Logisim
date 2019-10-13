package com.csc131.logisim;

import android.view.MotionEvent;

class ResetButton extends Button {

    ResetButton(int drawable, String tag){
        super(drawable, tag);
    }

    void press(){
        MainActivity.vibrate(200);
        Grid.resetGrid();
    }

    void action(MotionEvent e) throws Exception{}
    <T extends AbstractObject> void action(T a, MotionEvent event){}
}
