package com.example.dene.ui.dietlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dene.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.CheckedOutputStream;

public class CustomAdapter extends BaseAdapter {
    List<Food> foodList = new ArrayList<>();
    LayoutInflater inflater;
    Context context;
    public CustomAdapter(Context context, List<Food> foodList) {
        this.foodList = foodList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.list_view_row,null);
        ImageView image = row.findViewById(R.id.imageYemek);
        TextView name = row.findViewById(R.id.textViewName);
        TextView content = row.findViewById(R.id.textViewContent);
        Food food = foodList.get(position);
        name.setText(food.getFoodName());
        content.setText(food.getCalories());
        image.setImageBitmap(food.getImage());
        return row;
    }
}
