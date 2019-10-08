package com.csc131.logisim;

import android.app.Activity;
import android.view.View;

class AndGate extends AbstractObject {

    AndGate(float x, float y, Activity a){
        super(x,y,a);
        super.iv.setImageResource(R.drawable.andgate);
        super.iv.setClickable(true);
        super.iv.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                iv.setScaleX(1.1f);
                iv.setScaleY(1.1f);
            }
        });
    }



}
