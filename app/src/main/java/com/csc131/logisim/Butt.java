package com.csc131.logisim;

import android.view.ViewGroup;
import android.widget.ImageButton;

abstract class Butt extends ImageButton {

    Butt(){
        super(MainActivity.activity);
        super.setLayoutParams(new ViewGroup.LayoutParams(250, 250));
        super.setScaleType(ScaleType.FIT_CENTER);
        super.setBackgroundResource(R.drawable.border);

    }

}
