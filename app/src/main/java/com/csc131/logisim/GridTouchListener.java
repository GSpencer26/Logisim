package com.csc131.logisim;

import android.view.MotionEvent;
import android.view.View;
class GridTouchListener implements View.OnTouchListener {

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if(motionEvent.getAction() == motionEvent.ACTION_DOWN) {
            view.setOnTouchListener(null);
            MainActivity.draw.grid.addGate(Draw.closestBlock(motionEvent.getX()),Draw.closestBlock(motionEvent.getY()));
            Button.unpress();
            return true;
        }
        return false;
    }

}
