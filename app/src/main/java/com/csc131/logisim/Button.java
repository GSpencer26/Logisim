package com.csc131.logisim;

class Button extends AbstractButton {

    Button(int drawable, String tag){
        super(drawable, tag);
    }

    //Add this button to PressedButton
    void press(){
        PressedButton.press(this);
        MainActivity.vibrate(50);
    }
}
