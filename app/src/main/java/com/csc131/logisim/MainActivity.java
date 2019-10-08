package com.csc131.logisim;

import android.os.Bundle;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {
    static Grid grid;
    static Button button;
    static GateManager gm;
    static GridTouchListener gtl;
    static ConstraintLayout cl;
    static int imageSize = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        size.y = size.y - (int)getResources().getDimension(R.dimen.ButtonSize);
        ImageView view =  findViewById(R.id.grid);
        grid = new Grid(size,view);
        gtl = new GridTouchListener(view, this);
        button = new Button();
        cl = findViewById(R.id.GridLayout);
        gm = new GateManager(this, cl);
    }

    public void buttonClick(View v){
        button.press(v);
    }



}
