package com.csc131.logisim;

import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

abstract class AbstractObject {

    ArrayList<AbstractObject> inputs;
    int xposition, yposition;
    ImageView iv;

    AbstractObject(int x, int y) {
        iv = new ImageView(MainActivity.activity);
        inputs = new ArrayList<>();
        int size = 100;
        xposition = x;
        yposition = y;
        iv.setX(x-size/2f); //Position gate at cell center
        iv.setY(y-size/2f);
        iv.setLayoutParams(new LinearLayout.LayoutParams(size, size));
    }

    abstract void gridAction();     //Abstract action that a gate does when no button is pressed
    abstract boolean function();    //Abstract function that computes the state of the gate

    //Set gate a to be the input of gate b
    static void connectGates(AbstractObject a, AbstractObject b){
        if(!b.inputs.contains(a)) {
            b.inputs.add(a);
            Lightbulb.update();
        }

    }

    //Rotate the ImageView
    void rotate(){
        float rotation = iv.getRotation();
        iv.setRotation((rotation+90)%360);
    }



}
