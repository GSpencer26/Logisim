package com.csc131.logisim;

import java.util.ArrayList;

public class Grid {

    static ArrayList<AbstractObject> gates = new ArrayList<>();

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

    //Check if there is a gate at location and return position in array
    static int isGate(int x, int y) {
        for(int i=0; i<gates.size(); i++){
            if(gates.get(i).xposition == x && gates.get(i).yposition == y)
                return i;
        }
        return -1; //return -1 if none found
    }

    //Adds gate to ArrayList and the Grid layout
    static void addGate(AbstractObject a) {
        int x = Drawer.cellCenter(a.xposition);
        int y = Drawer.cellCenter(a.yposition);
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
            gates.remove(gateNum);      //Remove gate from grid and ImageView
            Drawer.draw();              //Redraw the grid to remove unused wires
            Lightbulb.update();         //Update the circuit
        }
    }

    //Delete all gates
    static void resetGrid(){
        clearLayout();
        gates = new ArrayList<>();
        Drawer.draw();
    }

    //Remove all gates from the grid layout
    private static void clearLayout(){
        for(AbstractObject g : gates){
            MainActivity.cl.removeView(g.iv);
        }
    }

    static void loadState(ArrayList<AbstractObject> state){
        clearLayout();
        gates = state;
        for(AbstractObject g : gates){
            MainActivity.cl.addView(g.iv);
        }
        Drawer.drawAllWires();
    }
}

