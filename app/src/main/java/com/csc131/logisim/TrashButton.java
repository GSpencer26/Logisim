package com.csc131.logisim;

class TrashButton extends Button {

    TrashButton(int drawable,String tag){
        super(drawable, tag);
    }

    void action(){
        PressedButton.press(this);
        MainActivity.vibrate(50);
    }
}
