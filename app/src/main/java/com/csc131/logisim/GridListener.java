package com.csc131.logisim;

import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;

class GridListener implements View.OnTouchListener {

    ArrayList<MotionEvent> events = new ArrayList<>();

    public boolean onTouch(View view, MotionEvent motionEvent){
    if(motionEvent.getAction() == motionEvent.ACTION_DOWN) {
        if(PressedButton.pressed==null){
            GridAction.action(motionEvent);
        }else {
            int x = Drawer.closestBlock(motionEvent.getX());
            int y = Drawer.closestBlock(motionEvent.getY());
            PressedButton.pressed.action(new AbstractObject(x,y),motionEvent);
            //ButtonAction.action(motionEvent);
        }
        return true;
    }
    return false;
}
}
