package com.example.summerproject2024.Information;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.summerproject2024.R;

import java.util.ArrayList;
import java.util.List;

public class Town_Info_Adapter extends BaseAdapter {

    private Context context;
    private ArrayList<Item> items;

    public Town_Info_Adapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }


    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.town_info_item, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.image);
        TextView nameView = convertView.findViewById(R.id.name);
        TextView locationView = convertView.findViewById(R.id.address);


        Item item = items.get(position);
        Log.v("PositionValue" , item.getLocation());
        nameView.setText(item.getName());
        locationView.setText(item.getLocation());
        imageView.setImageResource(item.getImageResourceId());

        return convertView;
    }

}
