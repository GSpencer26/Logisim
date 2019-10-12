package com.csc131.logisim;

import android.view.View;

public class ButtonListener implements View.OnClickListener {

    public void onClick(View v){
        Button button = (Button) v;
        button.action();
    }

}
