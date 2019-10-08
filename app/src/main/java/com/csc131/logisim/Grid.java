package com.csc131.logisim;

import android.app.Activity;
import android.drm.DrmStore;

public class Grid {

    private AbstractObject gates[][];
    Activity activity;
    Grid(int width, int height, Activity a){
        gates = new AbstractObject[width][height];
        activity = a;
    }

    AbstractObject getGate(int x, int y){
        return(gates[x][y]);
    }

    boolean addGate(int x, int y){
        int blockX = Draw.blockNum(x);
        int blockY = Draw.blockNum(y);
        if(gates[blockX][blockY] == null) {
            gates[blockX][blockY] = new AndGate(x, y, activity);
            return true;
        }
        return false;
    }

    boolean removeGate(int x, int y){
        if(gates[x][y]!=null){
            gates[x][y]= null;
            return true;
        }
        return false;
    }

    boolean moveGate(int x0, int y0, int x1, int y1){
        return true;
    }


}
