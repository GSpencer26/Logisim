package com.csc131.logisim;

import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

abstract class AbstractObject {

    final int maxInputs = 2;
    int xposition, yposition;
    ImageView iv;

    AbstractObject(int x, int y) {
        iv = new ImageView(Acti.get());
        int size = MainActivity.imageSize;
        xposition = x;
        yposition = y;
        iv.setX(x-size/2f);
        iv.setY(y-size/2f);
        iv.setLayoutParams(new LinearLayout.LayoutParams(size, size));
    }

    abstract boolean function();



}
