package com.csc131.logisim;

import android.view.MotionEvent;
import android.view.View;

class ButtonAction {

    static void action(MotionEvent motionEvent){
        final View pressed = Button.pressed;
        final int x = Drawer.closestBlock(motionEvent.getX());
        final int y = Drawer.closestBlock(motionEvent.getY());
        switch(pressed.getTag().toString()){
            case "and":
                Grid.addGate(new AndGate(x,y));
                break;
            case "or":
                Grid.addGate(new OrGate(x,y));
                break;
            case "not":
                Grid.addGate(new NotGate(x,y));
                break;
            case "led":
                Grid.addGate(new Lightbulb(x,y));
                break;
            case "toggle":
                Grid.addGate(new Toggle(x,y));
                break;
            case "wire":
                if(Grid.isGate(x,y)<0){
                    return;
                }
                MainActivity.grid.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent2) {
                        int x2 = Drawer.closestBlock(motionEvent2.getX());
                        int y2 = Drawer.closestBlock(motionEvent2.getY());
                        if(motionEvent2.getAction() == motionEvent2.ACTION_DOWN
                            && Grid.isGate(Drawer.closestBlock(x2), Drawer.closestBlock(y2))>=0){
                            if(x==x2 && y==y2) return true;
                            Drawer.drawWire(x,y,x2,y2);
                            AbstractObject.connectGates(Grid.getGate(x,y),
                                    Grid.getGate(x2,y2));
                            MainActivity.grid.setOnTouchListener(new GridListener());
                            Button.unpress();
                            return true;
                        }
                        return false;
                    }
                });
                break;
            case "trash":
                Grid.removeGate(x,y);
                break;
            case "save":
                break;
            case "aletter":
                break;
            case "bletter":
                break;
            case "cletter":
                break;
        }
    }
}
