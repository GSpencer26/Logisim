package com.csc131.logisim;

import android.view.ViewGroup;
import android.widget.ImageButton;

abstract class AbstractButton extends ImageButton {

    //Create ImageButton programmatically
    AbstractButton(int drawable, String tag){
        super(MainActivity.activity);
        super.setImageResource(drawable);
        super.setTag(tag);
        super.setLayoutParams(new ViewGroup.LayoutParams(250, 250));
        super.setScaleType(ScaleType.FIT_CENTER);
        super.setBackgroundResource(R.drawable.border);
        super.setOnClickListener(new ButtonListener()); //Set to listen using ButtonListener
    }

    abstract void press(); //Abstract action when pressed
}
