package com.csc131.logisim;

import android.view.View;

public class ButtonListener implements View.OnClickListener {

    public void onClick(View v){
        Butt button = (Butt) v;
        button.action();
    }

}
