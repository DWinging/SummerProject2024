package com.example.summerproject2024.Information;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.summerproject2024.DB.DatabaseHelper;
import com.example.summerproject2024.R;

import java.util.ArrayList;

public class University_Town_Info extends Fragment {

    private ListView list;
    public DatabaseHelper townDB;
    ArrayList<String>[] town_Info;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.university_town_fragment, container, false);

        list = view.findViewById(R.id.menuList);  // Ensure the ID matches the one in your XML layout

        townDB = new DatabaseHelper(getContext());
        town_Info = townDB.selectBusinessZone();

        ArrayList<Item> items = new ArrayList<>();

        for (int i = 0; i < town_Info.length; i++) {
            for (int j = 0; j < town_Info[i].size(); j++) {
                String name = town_Info[i].get(j);
                String location = town_Info[i].get(j);
                String category = town_Info[i].get(j);


                int imageResourceId = R.drawable.icon_food;

                items.add(new Item(name, location, category, imageResourceId));
            }


            Town_Info_Adapter adapter = new Town_Info_Adapter(getContext(), items);
            list.setAdapter(adapter);


        }
        return view;
    }

}

