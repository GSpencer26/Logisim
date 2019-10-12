package com.csc131.logisim;

class Toggle extends AbstractObject {

    boolean state;

    public Toggle(int x, int y) {
        super(x,y);
        state = true;
        toggle();
    }

    @Override
    boolean function() {
        return state;
    }

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