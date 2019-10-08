package com.csc131.logisim;

import android.view.View;
import android.widget.ImageView;
import android.graphics.Matrix;
class Button {
    View press;
    GridTouchListener gtl;

    Button(){
        gtl = MainActivity.gtl;
    }

    void rotate(ImageView v){
        Matrix matrix = new Matrix();
        v.setScaleType(ImageView.ScaleType.MATRIX);   //required
        matrix.postRotate( 90, 0, 0);
        v.setImageMatrix(matrix);
    }

    private void resetButton(){
        press.setOnTouchListener(null);
    }

    void press(View v) {
        if (press != null) {
            unpress();
        }
        press = v;
        gtl.getGridTouch(press);
        scaleButton(.9f);
    }

    void unpress() {
        resetButton();
        scaleButton();
    }

    private void scaleButton(){ scaleButton(1f);}

    private void scaleButton(float size){
        press.setScaleX(size);
        press.setScaleY(size);
    }

}
