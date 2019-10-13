package com.csc131.logisim;

import android.view.MotionEvent;

import java.util.ArrayList;

class StateButton extends Button {

    ArrayList<AbstractObject> state;

    StateButton(int drawable, String tag){
        super(drawable, tag);
        state = new ArrayList<>();
    }
    public void press(){
        if(PressedButton.pressed !=null && PressedButton.pressed.getTag().toString().equals("save")){
            state = Grid.setState();
            PressedButton.unpress();
            MainActivity.vibrate(100);
        } else {
            Grid.loadState(state);
            MainActivity.vibrate(200);
        }
    }

    <T extends AbstractObject> void action(T a, MotionEvent event){}

}
