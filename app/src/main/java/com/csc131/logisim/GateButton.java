package com.csc131.logisim;

class GateButton<E> extends Button {

    GateButton(int drawable, String tag){
        super(drawable, tag);
    }

    void action(){
        PressedButton.press(this);
        MainActivity.vibrate(50);
    }

}
