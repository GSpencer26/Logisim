package com.csc131.logisim;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;

public class GateManager{

    Activity activity;
    Button button;
    ConstraintLayout cl;

    GateManager (Activity a, ConstraintLayout c){
        activity = a;
        button = MainActivity.button;
        cl = c;

    }

    void getListener(View v){
        String tag = v.getTag().toString();
        if(tag.equals("and" )|| tag.equals("or") || tag.equals("not")){
            MainActivity.gtl.getGridTouch(v);
        }
    }

    void createGate(View v, MotionEvent motionEvent){
        switch (v.getTag().toString()){
            case "and":
                new AndGate(Grid.getPos(motionEvent.getX()),Grid.getPos(motionEvent.getY()),activity);
                break;
            case "or":
                new OrGate(Grid.getPos(motionEvent.getX()),Grid.getPos(motionEvent.getY()),activity);
                break;
            case "not":
                new NotGate(Grid.getPos(motionEvent.getX()),Grid.getPos(motionEvent.getY()),activity);
                break;
        }
        button.unpress();
    }

    AbstractObject newGate(){
        return null;
    }
}
