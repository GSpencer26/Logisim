package com.csc131.logisim;

import java.util.ArrayList;

class Lightbulb extends AbstractObject{

    static ArrayList<Lightbulb> leds = new ArrayList<>();

    Lightbulb(int x, int y){
        super(x,y);
        leds.add(this); //keep track of all lightbulbs on the grid
        update();
    }

    //Update all lightbulbs to calculate the state of each bulb
    static void update(){
        for(int i=0; i<leds.size(); i++) {
            if (!leds.get(i).function())
                leds.get(i).iv.setImageResource(R.drawable.lightbulboff);
            else
                leds.get(i).iv.setImageResource(R.drawable.lightbulbon);
        }
    }

    //Get the state of the first input
    boolean function() {
        if(inputs.size()==0){
            return false;
        }
        return inputs.get(0).function();
    }

    //No action when clicked and no button is selected
    void gridAction(){
    }
}
