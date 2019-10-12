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
        if(Button.pressed == null){
            Grid.loadState(state);
        } else {
            state = Grid.setState();
            Button.unpress();
        }
    }
}
