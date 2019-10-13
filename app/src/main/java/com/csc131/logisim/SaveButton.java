package com.csc131.logisim;

import android.view.MotionEvent;

class SaveButton extends Button {

    SaveButton(int drawable,String tag){
        super(drawable, tag);
    }

    void press(){
        PressedButton.press(this);
        MainActivity.vibrate(50);
    }

    <T extends AbstractObject> void action(T a, MotionEvent event){}

}
