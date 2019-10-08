package com.csc131.logisim;

import android.app.Activity;

class NotGate extends AbstractObject {
    public NotGate(float x, float y, Activity activity) {
        super(x,y,activity);
        super.iv.setImageResource(R.drawable.notgate);
    }
}
