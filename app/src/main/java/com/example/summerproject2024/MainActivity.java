package com.example.summerproject2024;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.summerproject2024.Campus_map.Campus_map;
import com.example.summerproject2024.Information.University_Number;
import com.example.summerproject2024.Information.University_Town_Info;

public class MainActivity extends AppCompatActivity {

    //FragmentManager
    private static FragmentManager fragmentManager;
    private static FragmentTransaction transaction;

    DrawerLayout drawerLayout;

    Campus_map campus_map;
    University_Number university_info;
    University_Town_Info university_town_info;

    ImageButton menu_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.main);
        menu_button = (ImageButton) findViewById(R.id.menu_button);

        campus_map = new Campus_map();

        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container_view, campus_map).commitAllowingStateLoss();

        menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.menu_button){
                    if(drawerLayout.isDrawerOpen(R.id.main)){
                        drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    else{
                        drawerLayout.openDrawer(GravityCompat.START);
                    }
                }
            }
        });
    }

}