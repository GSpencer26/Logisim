package com.csc131.logisim;

import android.view.MotionEvent;
import android.view.View;

public class ButtonAction {

    ButtonAction(MotionEvent motionEvent){

        View pressed = Button.pressed;
        int closeX = Draw.closestBlock(motionEvent.getX());
        int closeY = Draw.closestBlock(motionEvent.getY());

        switch(pressed.getTag().toString()){
            case "and":
                and(closeX, closeY);
                break;
            case "or":
                or(closeX, closeY);
                break;
            case "not":
                not(closeX,closeY);
                break;
            case "led":
                led(closeX,closeY);
                break;
            case "toggle":
                toggle(closeX,closeY);
                break;
            case "wire":
                break;
            case "trash":
                trash(closeX, closeY);
                break;
        }

        System.out.println(pressed.getTag().toString());
    }

    void and(int x, int y){
        Grid.addGate(new AndGate(x,y));
    }
    void or(int x, int y){
        Grid.addGate(new OrGate(x,y));
    }
    void not(int x, int y){
        Grid.addGate(new NotGate(x,y));
    }
    void led(int x, int y){
        Grid.addGate(new Lightbulb(x,y));
    }
    void toggle(int x, int y){
        Grid.addGate(new Toggle(x,y));
    }
    void wire(){

    }
    void trash(int x, int y){
        Grid.removeGate(x,y);
    }
}
