package com.csc131.logisim;

class Lightbulb extends AbstractObject{

    boolean state = false;

    Lightbulb(int x, int y){
        super(x,y);
        update();
    }

    void update(){
        if(state==false)
            super.iv.setImageResource(R.drawable.lightbulboff);
        else
            super.iv.setImageResource(R.drawable.lightbulbon);
    }

    boolean function() {
        return false;
    }
}
