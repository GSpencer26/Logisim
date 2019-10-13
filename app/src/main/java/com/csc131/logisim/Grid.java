package com.csc131.logisim;

import android.app.Activity;
import java.util.ArrayList;

public class Grid {

    static private ArrayList<AbstractObject> gates;
    static Activity activity;
    static int width, height;

    static void initialize(int w, int h, Activity a) {
        width = w;
        height = h;
        activity = a;
        gates = new ArrayList<>();
    }

    static AbstractObject getGate(int x, int y) {
        int gatePosition = isGate(x,y);
        return getGate(gatePosition);
    }

    static AbstractObject getGate(int gatePosition) {
        if(gatePosition>=0){
            return gates.get(gatePosition);
        }
        return null;
    }

    static int isGate(int x, int y) {
        for(int i=0; i<gates.size(); i++){
            if(gates.get(i).xposition == x && gates.get(i).yposition == y)
                return i;
        }
        return -1;
    }

    static void addGate(AbstractObject a) {
        int x = Drawer.closestBlock(a.xposition);
        int y = Drawer.closestBlock(a.yposition);
        int gateNum = isGate(x,y);
        if (gateNum==-1) {
            gates.add(a);
            MainActivity.cl.addView(a.iv);
        }
    }

    static void removeGate(int x, int y) {
        int gateNum = isGate(x,y);
        if(gateNum>=0) {
            MainActivity.cl.removeView(gates.get(gateNum).iv);
            gates.remove(gateNum);
            Drawer.draw();
            Lightbulb.update();
        }
        for(int i=0; i<gates.size(); i++){
            for(int j=0; j<gates.get(i).inputs.size(); j++){
                AbstractObject.connectGates(gates.get(i),gates.get(i).inputs.get(j));
            }
        }
    }

    static void resetGrid(){
        clearLayout();
        gates = new ArrayList<>();
        Drawer.draw();
    }

    private static void clearLayout(){
        for(int i=0; i<gates.size(); i++){
            MainActivity.cl.removeView(gates.get(i).iv);
        }
    }

    static void loadState(ArrayList<AbstractObject> state){
        clearLayout();
        gates = state;
        for(int i=0; i<gates.size(); i++){
            MainActivity.cl.addView(gates.get(i).iv);
        }
        drawAllWires();
    }

    static ArrayList<AbstractObject> setState(){
        return gates;
    }

    static void drawAllWires(){
        for(int i=0; i<gates.size(); i++){
            for(int j=0; j<gates.get(i).inputs.size(); j++){
                Drawer.drawWire(gates.get(i),gates.get(i).inputs.get(j));
            }
        }
    }
}

