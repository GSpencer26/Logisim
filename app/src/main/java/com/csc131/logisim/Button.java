package com.csc131.logisim;

import android.view.ViewGroup;
import android.widget.ImageButton;

abstract class Button extends ImageButton {

    Button(int drawable, String tag){
        super(MainActivity.activity);
        super.setImageResource(drawable);
        super.setTag(tag);
        super.setLayoutParams(new ViewGroup.LayoutParams(250, 250));
        super.setScaleType(ScaleType.FIT_CENTER);
        super.setBackgroundResource(R.drawable.border);
        super.setOnClickListener(new ButtonListener());

    }

    abstract void action();

}
