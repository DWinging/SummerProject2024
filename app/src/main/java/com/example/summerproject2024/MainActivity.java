package com.example.summerproject2024;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ScrollView scrollView;
    HorizontalScrollView horizontalScrollView;

    ImageView campus_map;
    Bitmap bitmap;
    Bitmap resized;

    TextView text;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        scrollView = (ScrollView) findViewById(R.id.ScrollView);
        horizontalScrollView = (HorizontalScrollView) findViewById(R.id.HorizontalScrollView);

        bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.campus_map);
        resized = Bitmap.createScaledBitmap(bitmap, 1440, 1080, true);
        campus_map = (ImageView) findViewById(R.id.campus_map);
        campus_map.setImageBitmap(resized);

        text = (TextView) findViewById(R.id.textView);

        campus_map.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    float x = event.getRawX() + horizontalScrollView.getScrollX();
                    float y = event.getRawY() + scrollView.getScrollY();
                    text.setText("" + x + "\n " + y );
                }
                return false;
            }
        });
    }
}