package com.csc131.logisim;

import android.app.Activity;

public class Grid {

    static private AbstractObject gates[][];
    static Activity activity;
    static void initalize(int width, int height, Activity a){
        gates = new AbstractObject[width][height];
        activity = a;
    }

    static AbstractObject getGate(int x, int y){
        return(gates[x][y]);
    }

    static boolean addGate(AbstractObject a){
        int blockX = Draw.blockNum(a.xposition);
        int blockY = Draw.blockNum(a.yposition);
        if(gates[blockX][blockY] == null) {
            gates[blockX][blockY] = a;
            MainActivity.cl.addView(a.iv);
            return true;
        }
        return false;
    }

    static boolean removeGate(int x, int y){
        int blockX = Draw.blockNum(x);
        int blockY = Draw.blockNum(y);
        if(gates[blockX][blockY]!=null){
            MainActivity.cl.removeView(gates[blockX][blockY].iv);
            gates[blockX][blockY]= null;
            return true;
        }
        return false;
    }

    boolean moveGate(int x0, int y0, int x1, int y1){
        return true;
    }


}
