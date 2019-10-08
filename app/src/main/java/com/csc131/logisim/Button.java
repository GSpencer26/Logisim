package com.csc131.logisim;

import android.view.View;
class Button {
    private static View press;

    static private void resetButton(){
        press.setOnTouchListener(null);
    }

    static void press(View v) {
        if (press != null) {
            unpress();
        }
        press = v;
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
        press.setScaleX(size);
        press.setScaleY(size);
    }

}
