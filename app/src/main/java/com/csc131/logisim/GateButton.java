package com.csc131.logisim;

import android.view.MotionEvent;

class GateButton<T extends AbstractObject> extends Button {

    GateButton(int drawable, String tag){
        super(drawable, tag);
    }

    void press(){
        PressedButton.press(this);
        MainActivity.vibrate(50);
    }
    <T extends AbstractObject> void action(T a, MotionEvent event){
        int x = Drawer.closestBlock(event.getX());
        int y = Drawer.closestBlock(event.getY());
        Grid.addGate(a);
    }
}
