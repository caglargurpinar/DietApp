package com.example.dene.ui.dietlist;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.dene.R;

import java.util.ArrayList;
import java.util.List;

public class DietlistFragment extends Fragment {

    List<Food> foodList = new ArrayList<>();
    ListView listView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_dietlist, null);
        foodList.add(new Food("Hamburger", "261 kcal (100g)", BitmapFactory.decodeResource(getResources(),R.drawable.burger)));
        foodList.add(new Food("Brokoli", "33,7 kcal (100g)", BitmapFactory.decodeResource(getResources(),R.drawable.brokoli)));
        foodList.add(new Food("Domates", "20 kcal (100g)", BitmapFactory.decodeResource(getResources(),R.drawable.domates)));
        foodList.add(new Food("Tavuk Döner", "124 kcal (100g)", BitmapFactory.decodeResource(getResources(),R.drawable.tavukdoner)));
        foodList.add(new Food("İskender", "151 kcal (100g)", BitmapFactory.decodeResource(getResources(),R.drawable.iskender)));
        foodList.add(new Food("İslim Kebabı", "87 kcal (100g)", BitmapFactory.decodeResource(getResources(),R.drawable.islim)));
        foodList.add(new Food("Pizza", "266 kcal (100g)", BitmapFactory.decodeResource(getResources(),R.drawable.pizza)));


        listView = root.findViewById(R.id.listView);
        CustomAdapter adapter = new CustomAdapter(getContext(),foodList);
        listView.setAdapter(adapter);
        return root;
    }
}