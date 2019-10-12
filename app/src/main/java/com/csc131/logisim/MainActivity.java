package com.csc131.logisim;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Point;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.Display;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {
    static ConstraintLayout cl;
    static int imageSize = 100;
    static ImageView grid;
    static Activity activity;
    static Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        activity = this;
        cl = findViewById(R.id.GridLayout);
        display.getSize(size);
        size.y = size.y - (int)getResources().getDimension(R.dimen.ButtonSize);
        vibrator = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);
        grid =  findViewById(R.id.grid);
        Drawer.set(size, grid);
        Drawer.draw();
    }

    public void buttonClick(View v){
        Button.press(v);
        vibrate(50);
    }

    public void reset(View v) {
        vibrate(200);
        Grid.resetGrid();
    }

    public void addButtons(View v){
        HorizontalScrollView toolbar =  findViewById(R.id.toolbar);
    }

    static public void vibrate(long duration){
        vibrator.vibrate(VibrationEffect.createOneShot(duration,75));
    }
}
