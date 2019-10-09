package com.csc131.logisim;

import android.os.Bundle;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {
    static Draw draw;
    static ConstraintLayout cl;
    static int imageSize = 100;
    ImageView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        Acti.setActivity(this);
        display.getSize(size);
        size.y = size.y - (int)getResources().getDimension(R.dimen.ButtonSize);
        view =  findViewById(R.id.grid);
        draw = new Draw(size,view);
        cl = findViewById(R.id.GridLayout);
        view.setOnTouchListener(new GridTouchListener());

    }

    public void placeGate(View v){
        Button.press(v);

    }
    public void buttonClick(View v){
        Button.press(v);
    }

}
