package com.example.summerproject2024.Information;

import android.app.Activity;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;

import com.example.summerproject2024.R;

public class Info_activity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.info_activity);

    }
}
