package com.csc131.logisim;

import android.app.Activity;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Grid {

    static private AbstractObject[][] gates;
    static Activity activity;
    static int width, height;

    static void initialize(int w, int h, Activity a) {
        width = w;
        height = h;
        activity = a;
        gates = new AbstractObject[width][height];
    }

    static AbstractObject getGate(int x, int y) {
        return (gates[x][y]);
    }

    static boolean isGate(int x, int y) {
        return (gates[x][y]!= null);
    }

    static void addGate(AbstractObject a) {
        int blockX = Drawer.blockNum(a.xposition);
        int blockY = Drawer.blockNum(a.yposition);
        if (!isGate(blockX, blockY)) {
            gates[blockX][blockY] = a;
            MainActivity.cl.addView(a.iv);
        }
    }

    static void removeGate(int x, int y) {
        int blockX = Drawer.blockNum(x);
        int blockY = Drawer.blockNum(y);
        if(gates[blockX][blockY]!=null) {
            MainActivity.cl.removeView(gates[blockX][blockY].iv);
            gates[blockX][blockY] = null;
            Drawer.draw();
            Lightbulb.update();
        }
    }

    static void resetGrid(){
        for(AbstractObject[] i : gates){
            for(AbstractObject j : i){
                if(j != null) {
                    int x = Drawer.blockNum(j.xposition);
                    int y = Drawer.blockNum(j.yposition);
                    if (isGate(x,y)) {
                        MainActivity.cl.removeView(j.iv);
                    }
                }
            }
        }
        gates = new AbstractObject[width][height];
        Drawer.draw();
    }

    static void findWires(){
        for(AbstractObject[] i : gates){
            for(AbstractObject j : i){
                if(j != null) {
                    int x = Drawer.blockNum(j.xposition);
                    int y = Drawer.blockNum(j.yposition);
                    if (isGate(x,y)) {
                        for(int k=0; k<j.inputs.size();k++){
                            Drawer.drawWire(j.xposition,j.yposition,j.inputs.get(k).xposition, j.inputs.get(k).yposition);
                        }
                    }
                }
            }
        }
    }

}

