package com.csc131.logisim;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.LinearLayout;

class AbstractObject {

    final int maxInputs = 2;
    int xPosition, yPosition;
    ImageView iv;

    int getX(){
        return xPosition;
    }

    int getY(){
        return yPosition;
    }

    AbstractObject(float x, float y, Activity activity) {
        iv = new ImageView(activity);
        int size = MainActivity.imageSize;
        iv.setX(x-size/2f);
        iv.setY(y-size/2f);
        iv.setLayoutParams(new LinearLayout.LayoutParams(size, size));
        iv.setClickable(true);
        MainActivity.cl.addView(iv);
    }

}
