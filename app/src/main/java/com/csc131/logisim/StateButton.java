package com.csc131.logisim;

import android.view.MotionEvent;

import java.util.ArrayList;

class StateButton extends AbstractButton {

    ArrayList<AbstractObject> state;

    StateButton(int drawable, String tag){
        super(drawable, tag);
        state = new ArrayList<>();
    }
    public void press(){
        if(PressedButton.pressed !=null && PressedButton.pressed.getTag().toString().equals("save")){
            state = Grid.gates;                 //Copy gates to the state if save is selected
            PressedButton.unpress();            //Unpress the save button
            MainActivity.vibrate(100);  //Slightly longer feedback
        } else {
            Grid.loadState(state);              //Load the current state if anything but state is selected
            MainActivity.vibrate(200);  //Long feedback
        }
    }

    <T extends AbstractObject> void action(T a, MotionEvent event){}

}
