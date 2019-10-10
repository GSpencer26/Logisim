package com.csc131.logisim;

import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

abstract class AbstractObject {

    ArrayList<AbstractObject> inputs;
    int xposition, yposition;
    ImageView iv;

    AbstractObject(int x, int y) {
        iv = new ImageView(MainActivity.activity);
        inputs = new ArrayList<>();
        int size = MainActivity.imageSize;
        xposition = x;
        yposition = y;
        iv.setX(x-size/2f);
        iv.setY(y-size/2f);
        iv.setLayoutParams(new LinearLayout.LayoutParams(size, size));
    }

    abstract boolean function();

    void drawWires(){
        for(int i=0; i<inputs.size();i++){
            Drawer.drawWire(xposition,yposition,inputs.get(i).xposition, inputs.get(i).yposition);
        }
    }

    static void connectGates(AbstractObject a, AbstractObject b){
        if(!b.inputs.contains(a)) {
            b.inputs.add(a);
            Lightbulb.update();
        }

    }



}
