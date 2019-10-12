package com.csc131.logisim;

import java.util.ArrayList;

class StateButton extends Button {

    ArrayList<AbstractObject> state;

    StateButton(int drawable, String tag){
        super(drawable, tag);
        state = new ArrayList<>();
    }
    public void action(){
        if(PressedButton.pressed.getTag().toString().equals("save")){
            state = Grid.setState();
            PressedButton.unpress();
            MainActivity.vibrate(100);
        } else {
            Grid.loadState(state);
            MainActivity.vibrate(200);
        }
    }
}
