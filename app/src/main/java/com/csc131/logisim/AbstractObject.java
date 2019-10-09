package com.csc131.logisim;

import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

abstract class AbstractObject {

    ArrayList<AbstractObject> inputs;
    int xposition, yposition;
    ImageView iv;

    AbstractObject(int x, int y) {
        iv = new ImageView(Acti.get());
        inputs = new ArrayList<>();
        int size = MainActivity.imageSize;
        xposition = x;
        yposition = y;
        iv.setX(x-size/2f);
        iv.setY(y-size/2f);
        iv.setLayoutParams(new LinearLayout.LayoutParams(size, size));
    }

    abstract boolean function();

    static void connectGates(AbstractObject a, AbstractObject b){
        a.inputs.add(b);
    }



}
