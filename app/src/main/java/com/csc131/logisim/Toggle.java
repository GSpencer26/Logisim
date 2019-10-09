package com.csc131.logisim;

import android.view.View;

class Toggle extends AbstractObject {

    boolean state = false;

    public Toggle(int x, int y) {
        super(x,y);
        super.iv.setImageResource(R.drawable.toggleswitchoff);
        super.iv.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                toggle();
            }
        });
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
    }
}
