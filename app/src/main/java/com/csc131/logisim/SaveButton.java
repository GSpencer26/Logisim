package com.csc131.logisim;

class SaveButton extends Button {

    SaveButton(int drawable,String tag){
        super(drawable, tag);
    }

    void press(){
        PressedButton.press(this);
        MainActivity.vibrate(50);
    }

}
