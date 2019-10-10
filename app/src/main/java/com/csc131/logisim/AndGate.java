package com.csc131.logisim;

class AndGate extends AbstractObject {

    AndGate(int x, int y){
        super(x,y);
        super.iv.setImageResource(R.drawable.andgate);
    }

    boolean function() {
        drawWires();
        if(inputs.size()==0) return false;
        for(int i=0; i<inputs.size(); i++){
            if(!inputs.get(i).function()){
                return false;
            }
        }
        return true;
    }


}
