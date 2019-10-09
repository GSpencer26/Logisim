package com.csc131.logisim;

import android.view.View;
class Button {
    static View pressed;

    static private void resetButton(){
        pressed.setOnTouchListener(null);
    }

    static void press(View v) {
        if (pressed != null) {
            unpress();
        }
        pressed = v;
        scaleButton(.9f);
    }

    static void unpress() {
        resetButton();
        scaleButton();
    }

    static private void scaleButton(){
        scaleButton(1f);
    }

    static private void scaleButton(float size){
        pressed.setScaleX(size);
        pressed.setScaleY(size);
    }

}
