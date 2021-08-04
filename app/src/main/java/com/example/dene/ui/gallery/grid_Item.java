package com.example.dene.ui.gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import com.example.dene.R;
import android.widget.ImageView;
import android.widget.TextView;

public class grid_Item extends AppCompatActivity {

    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid__item);

        image = findViewById(R.id.galleryimage);

        Intent intent = getIntent();
        image.setImageResource(intent.getIntExtra("galleryimage",0));
    }
}