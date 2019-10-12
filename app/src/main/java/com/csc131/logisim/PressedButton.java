package com.csc131.logisim;

class PressedButton {
    static Button pressed;

    static private void resetButton(){
        pressed = null;

    }

    static void press(Button v) {
        if(v.equals(pressed)){
            unpress();
            return;
        }
        if (pressed != null) {
            unpress();
        }
        pressed = v;
        scaleButton(.9f);
        MainActivity.grid.setOnTouchListener(new GridListener());
    }

    static void unpress() {
        scaleButton();
        resetButton();
    }

    static private void scaleButton(){
        scaleButton(1f);
    }

    static private void scaleButton(float size){
        pressed.setScaleX(size);
        pressed.setScaleY(size);
    }

}
