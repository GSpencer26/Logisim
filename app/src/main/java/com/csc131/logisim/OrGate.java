package com.csc131.logisim;

class OrGate extends AbstractObject {
    public OrGate(int x, int y) {
        super(x,y);
        super.iv.setImageResource(R.drawable.orgate);

    }

    //Computes OR operator on all finite inputs
    boolean function() {
        for(int i=0; i<inputs.size(); i++){
            if(inputs.get(i).function()){
                return true;
            }
        }
        return false;
    }

    //Rotate the imageView when clicked and no button is selected
    void gridAction(){
        super.rotate();
    }
}
