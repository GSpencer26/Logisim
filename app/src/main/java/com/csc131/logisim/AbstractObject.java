package com.csc131.logisim;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.LinearLayout;

class AbstractObject {

    final int maxInputs = 2;
    ImageView iv;

    AbstractObject(float x, float y, Activity activity) {
        iv = new ImageView(Acti.get());
        int size = MainActivity.imageSize;
        iv.setX(x-size/2f);
        iv.setY(y-size/2f);
        iv.setLayoutParams(new LinearLayout.LayoutParams(size, size));
        MainActivity.cl.addView(iv);
    }

}
