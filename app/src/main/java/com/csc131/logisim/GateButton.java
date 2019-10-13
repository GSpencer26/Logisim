package com.csc131.logisim;

class GateButton extends Button {

    GateButton(int drawable, String tag){
        super(drawable, tag);
    }

    void press(){
        PressedButton.press(this);
        MainActivity.vibrate(50);
    }
}
