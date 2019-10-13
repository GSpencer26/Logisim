package com.csc131.logisim;

import android.view.MotionEvent;

class WireButton extends Button {

    WireButton(int drawable,String tag){
        super(drawable, tag);
    }

    void press(){
        PressedButton.press(this);
        MainActivity.vibrate(50);
    }

    <T extends AbstractObject> void action(T a, MotionEvent event){}

}
