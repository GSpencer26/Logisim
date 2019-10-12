package com.csc131.logisim;

class WireButton extends Button {

    WireButton(int drawable,String tag){
        super(drawable, tag);
    }

    void action(){
        PressedButton.press(this);
        MainActivity.vibrate(50);
    }
}
