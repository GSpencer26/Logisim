package com.csc131.logisim;

import android.view.MotionEvent;

class GridAction {

    static void action(MotionEvent motionEvent){
       final int x = Drawer.closestBlock(motionEvent.getX());
        final int y = Drawer.closestBlock(motionEvent.getY());
        int gatePosition = Grid.isGate(x,y);
        if(gatePosition>=0){
            MainActivity.vibrate(50);
            Grid.getGate(gatePosition).gridAction();
        }
    }
}
