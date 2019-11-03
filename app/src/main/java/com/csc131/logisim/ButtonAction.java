package com.csc131.logisim;

import android.view.MotionEvent;
import android.view.View;

class ButtonAction {

    static void action(MotionEvent motionEvent){
        final View pressed = PressedButton.pressed;
        final int x = Drawer.cellCenter(motionEvent.getX());
        final int y = Drawer.cellCenter(motionEvent.getY());
        MainActivity.vibrate(50);

        //Determine which button is pressed and do action
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
                //Set the grid to listen for a second input
                MainActivity.grid.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent2) {
                        int x2 = Drawer.cellCenter(motionEvent2.getX());
                        int y2 = Drawer.cellCenter(motionEvent2.getY());
                        if(motionEvent2.getAction() == motionEvent2.ACTION_DOWN
                            && Grid.isGate(Drawer.cellCenter(x2), Drawer.cellCenter(y2))>=0){
                            if(x==x2 && y==y2) return true;
                            MainActivity.vibrate(50);
                            Drawer.drawWire(x,y,x2,y2);
                            AbstractObject.connectGates(Grid.getGate(x,y),
                                    Grid.getGate(x2,y2));
                            MainActivity.grid.setOnTouchListener(new GridListener());
                            PressedButton.unpress();
                            return true;
                        }
                        return false;
                    }
                });
                return;
            case "trash":
                Grid.removeGate(x,y);
                break;
        }
        PressedButton.unpress();
    }
}
