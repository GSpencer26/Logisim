package com.csc131.logisim;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Point;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.Display;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {
    static ConstraintLayout cl;
    static int imageSize = 100;
    static ImageView grid;
    static Activity activity;
    private static Vibrator vibrator;

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
        grid.setOnTouchListener(new GridListener());
        addButtons();
        Drawer.set(size, grid);
        Drawer.draw();

    }

    //Create toolbar buttons programmatically
    public void addButtons(){
        LinearLayout toolbar = findViewById(R.id.toolbar);
        toolbar.addView(new ResetButton(R.drawable.reset,"reset"));
        toolbar.addView(new GateButton(R.drawable.andgate,"and"));
        toolbar.addView(new GateButton(R.drawable.orgate,"or"));
        toolbar.addView(new GateButton(R.drawable.notgate,"not"));
        toolbar.addView(new GateButton(R.drawable.toggleswitchoff,"toggle"));
        toolbar.addView(new GateButton(R.drawable.lightbulboff,"led"));
        toolbar.addView(new WireButton(R.drawable.wire,"wire"));
        toolbar.addView(new TrashButton(R.drawable.trash, "trash"));
        toolbar.addView(new SaveButton(R.drawable.save, "save"));
        toolbar.addView(new StateButton(R.drawable.aletter,"a"));
        toolbar.addView(new StateButton(R.drawable.bletter,"b"));
        toolbar.addView(new StateButton(R.drawable.cletter,"c"));

    }

    //Haptic feedback on touch
    static public void vibrate(long duration){
        vibrator.vibrate(VibrationEffect.createOneShot(duration,75));
    }
}
