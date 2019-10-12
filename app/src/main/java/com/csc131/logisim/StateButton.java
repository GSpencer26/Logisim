package com.csc131.logisim;

import android.view.View;

import java.util.ArrayList;

class StateButton extends Butt {

    ArrayList<AbstractObject> state;

    StateButton(int drawable){
        state = new ArrayList<>();
        super.setImageResource(drawable);
        super.setOnClickListener(new ButtonListener());
    }
    public void action(){
        if(Button.pressed.getTag().toString().equals("save")){
            state = Grid.setState();
            Button.unpress();
            MainActivity.vibrate(100);
        } else {
            Grid.loadState(state);
            MainActivity.vibrate(200);
        }
    }
}
