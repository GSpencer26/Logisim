package com.csc131.logisim;

class ResetButton extends AbstractButton {

    ResetButton(int drawable, String tag) {
        super(drawable, tag);
    }

    //Reset the grid on click
    void press() {
        MainActivity.vibrate(200);
        Grid.resetGrid();
    }
}