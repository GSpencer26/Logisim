package com.csc131.logisim;

class OrGate extends AbstractObject {
    public OrGate(int x, int y) {
        super(x,y);
        super.iv.setImageResource(R.drawable.orgate);

    }

    @Override
    boolean function() {
        return false;
    }
}
