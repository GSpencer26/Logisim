package com.csc131.logisim;

import android.view.MotionEvent;

class GridAction {

    //Do gate action when no button is selected (i.e. rotate or toggle)
    static void action(MotionEvent motionEvent){
       final int x = Drawer.cellCenter(motionEvent.getX());
        final int y = Drawer.cellCenter(motionEvent.getY());
        int gatePosition = Grid.isGate(x,y);
        if(gatePosition>=0){
            MainActivity.vibrate(50);
            Grid.getGate(gatePosition).gridAction();
        }
    }
}
