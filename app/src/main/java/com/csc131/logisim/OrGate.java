package com.csc131.logisim;

class OrGate extends AbstractObject {
    public OrGate(int x, int y) {
        super(x,y);
        super.iv.setImageResource(R.drawable.orgate);

    }

    @Override
    boolean function() {
        for(int i=0; i<inputs.size(); i++){
            if(inputs.get(i).function()){
                return true;
            }
        }
        return false;
    }

    void gridAction(){
        super.rotate();
    }
}
