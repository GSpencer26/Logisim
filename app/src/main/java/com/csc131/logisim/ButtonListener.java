package com.csc131.logisim;

import android.view.View;

public class ButtonListener implements View.OnClickListener {

    //Do press action when clicked
    public void onClick(View v){
        AbstractButton button = (AbstractButton) v;
        button.press();
    }

}
