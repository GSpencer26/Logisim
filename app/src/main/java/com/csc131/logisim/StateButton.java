package com.csc131.logisim;

import android.view.View;

import java.util.ArrayList;

class StateButton extends Butt {

    ArrayList<AbstractObject> state;

    StateButton(int drawable){
        state = new ArrayList<>();
        super.setImageResource(drawable);
        super.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                StateButton state = (StateButton) v;
                state.action();
            }
        });
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
