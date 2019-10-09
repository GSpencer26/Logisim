package com.csc131.logisim;

import android.view.MotionEvent;
import android.view.View;

public class ButtonAction {

    ButtonAction (MotionEvent motionEvent){

        View pressed = Button.pressed;
        final int closeX = Draw.closestBlock(motionEvent.getX());
        final int closeY = Draw.closestBlock(motionEvent.getY());

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
                MainActivity.grid.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent2) {
                        if(motionEvent2.getAction() == motionEvent2.ACTION_DOWN && Grid.isGate(Draw.closestBlock(motionEvent2.getX()),
                                Draw.closestBlock(motionEvent2.getY()))){
                            int closeX2 = Draw.closestBlock(motionEvent2.getX());
                            int closeY2 = Draw.closestBlock(motionEvent2.getY());
                            wire(closeX, closeY, closeX2, closeY2);
                            MainActivity.grid.setOnTouchListener(new GridListener());
                            Button.unpress();
                            return true;
                        }
                        return false;
                    }
                });
                break;
            case "trash":
                trash(closeX, closeY);
                break;
        }

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
    void wire(int x, int y, int x2, int y2){
        MainActivity.draw.drawWire(x,y,x2,y2);
        AbstractObject.connectGates(Grid.getGate(Draw.blockNum(x),Draw.blockNum(y)),
                Grid.getGate(Draw.blockNum(x2),Draw.blockNum(y2)));
    }
    void trash(int x, int y){
        Grid.removeGate(x,y);
    }
}
