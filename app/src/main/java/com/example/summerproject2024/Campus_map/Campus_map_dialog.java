package com.example.summerproject2024.Campus_map;

import android.app.Dialog;
import android.content.Context;

import androidx.annotation.NonNull;

import com.example.summerproject2024.DB.DatabaseHelper;

import java.util.ArrayList;

public class Campus_map_dialog extends Dialog {

    DatabaseHelper db;
    String building_code = "";
    ArrayList<String> info;
    String img;

    public Campus_map_dialog(@NonNull Context context) {
        super(context);

        db = new DatabaseHelper(context);
    }

    @Override
    protected void onStart() {
        super.onStart();
        building_Image(building_code);
        building_info(building_code);
    }

    public void building_Image(String code){

    }

    public void building_info(String code){

    }
}
