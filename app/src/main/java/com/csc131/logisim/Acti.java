package com.csc131.logisim;

import android.app.Activity;

public class Acti {

    static Activity activity;

    static void setActivity(Activity a ){
        activity = a;
    }

    static Activity get(){
        return activity;
    }
}
