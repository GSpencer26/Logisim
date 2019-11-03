package com.csc131.logisim;

class Toggle extends AbstractObject {

    boolean state;

    public Toggle(int x, int y) {
        super(x,y);
        state = true;
        toggle();
    }

    //Return the state. No function since direct input.
    boolean function() {
        return state;
    }

    //Toggle input state on touch
    void toggle(){
        state = !state;
        if(state)
            super.iv.setImageResource(R.drawable.toggleswitchon);
        else
            super.iv.setImageResource(R.drawable.toggleswitchoff);
        Lightbulb.update();
    }

    void gridAction(){
        toggle();
    }

}