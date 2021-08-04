package com.example.dene.ui.dietlist;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class Food {
    private String foodName;
    private String calories;
    private Bitmap image;

    public Food(String foodName, String calories, Bitmap image) {
        this.foodName = foodName;
        this.calories = calories;
        this.image = image;
    }

    public String getFoodName() {
        return foodName;
    }

    public Bitmap getImage() {
        return image;
    }

    public String getCalories() {
        return calories;
    }
}
