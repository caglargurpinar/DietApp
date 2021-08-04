package com.example.dene.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.dene.R;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    GridView gridView;
    int [] foodImages = {R.drawable.hamburger,R.drawable.iskender_kebap,R.drawable.kiymali_pide,R.drawable.lahmacun,
            R.drawable.patlican_kebap,R.drawable.pizza2,R.drawable.sonbahar_corbasi,R.drawable.spagetti};
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);


        gridView = root.findViewById(R.id.gridView);

        CustomAdapter customAdapter = new CustomAdapter();

        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(container.getContext(), grid_Item.class);
                intent.putExtra("galleryimage",foodImages[position]);
                startActivity(intent);
            }
        });



        return root;
    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount(){
            return foodImages.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view1 = getLayoutInflater().inflate(R.layout.row_data,null);
            ImageView image = view1.findViewById(R.id.images);
            image.setImageResource(foodImages[position]);
            return view1;
        }
    }

}