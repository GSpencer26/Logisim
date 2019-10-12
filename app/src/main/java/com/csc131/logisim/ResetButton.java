package com.csc131.logisim;

class ResetButton extends Button {

    ResetButton(int drawable, String tag){
        super(drawable, tag);
    }

    void action(){
        MainActivity.vibrate(200);
        Grid.resetGrid();
    }
}
