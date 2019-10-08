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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        Acti.setActivity(this);
        display.getSize(size);
        size.y = size.y - (int)getResources().getDimension(R.dimen.ButtonSize);
        ImageView view =  findViewById(R.id.grid);
        draw = new Draw(size,view);
        cl = findViewById(R.id.GridLayout);
    }

    public void andClick(View v){
        
    }
    public void orClick(View v){
        
    }
    public void notClick(View v){
        
    }
    public void ledClick(View v){
        
    }
    public void toggleClick(View v){
        
    }
    public void wireClick(View v){
        
    }
    public void removeClick(View v){
        
    }
    public void buttonClick(View v){
        Button.press(v);
    }





}
