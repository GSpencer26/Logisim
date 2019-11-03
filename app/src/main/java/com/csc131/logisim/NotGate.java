package com.csc131.logisim;

class NotGate extends AbstractObject {
    public NotGate(int x, int y) {
        super(x,y);
        super.iv.setImageResource(R.drawable.notgate);
    }

    //Return the opposite state of input
    boolean function() {
        if(inputs.size()>0){
            return !inputs.get(0).function();
        }
        return false;
    }

    //Rotate the imageView when clicked and no button is selected
    void gridAction(){
        super.rotate();
    }

}
