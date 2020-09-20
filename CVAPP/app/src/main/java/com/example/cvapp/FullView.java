package com.example.cvapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class FullView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_view);

        ImageView imageView = findViewById(R.id.img_full);

        int image_id = getIntent().getExtras().getInt("image_id");

        imageView.setImageResource(image_id);

    }
}
