package com.csc131.logisim;

import android.view.MotionEvent;
import android.view.View;

class GridListener implements View.OnTouchListener {

    public boolean onTouch(View view, MotionEvent motionEvent){
    if(motionEvent.getAction() == motionEvent.ACTION_DOWN) {

        //Determine if a button is selected
        if(PressedButton.pressed==null){    //Preform a action on an existing gate
            GridAction.action(motionEvent);
        }else {                             //Preform the action of the selected button
            ButtonAction.action(motionEvent);
        }
        return true;
    }
    return false;
}
}
