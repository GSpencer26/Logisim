package com.csc131.logisim;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Point;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {
    static Draw draw;
    static ConstraintLayout cl;
    static int imageSize = 100;
    static ImageView grid;
    static Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        activity = this;
        display.getSize(size);
        size.y = size.y - (int)getResources().getDimension(R.dimen.ButtonSize);
        grid =  findViewById(R.id.grid);
        draw = new Draw(size, grid);
        cl = findViewById(R.id.GridLayout);
        grid.setOnTouchListener(new GridListener());

    }

    public void buttonClick(View v){
        Button.press(v);
    }

    public void reset(View v){
    }

}
