package com.csc131.logisim;

class PressedButton {

    static Button pressed;

    static void press(Button button) {
        if(button.equals(pressed)){
            unpress();
            return;
        }
        if (pressed != null)
            unpress();
        pressed = button;
        scaleButton(.9f);
    }

    static void unpress() {
        scaleButton(1f);
        pressed = null;
    }

    static private void scaleButton(float size){
        pressed.setScaleX(size);
        pressed.setScaleY(size);
    }

}
