package com.csc131.logisim;

class PressedButton {

    static AbstractButton pressed;

    static void press(AbstractButton button) {
        if(button.equals(pressed)){ //If button already selected, deselect
            unpress();
            return;
        }
        unpress();
        pressed = button;           //Set selected button
        scaleButton(.9f);
        MainActivity.grid.setOnTouchListener(new GridListener());
    }

    static void unpress() {
        scaleButton(1f);
        pressed = null;
    }

    //Shrink/expand button to show which is selected
    static private void scaleButton(float size){
        if(pressed!=null) {
            pressed.setScaleX(size);
            pressed.setScaleY(size);
        }
    }

}
