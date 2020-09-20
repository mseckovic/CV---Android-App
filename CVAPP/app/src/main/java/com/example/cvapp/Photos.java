package com.example.cvapp;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class Photos extends AppCompatActivity {


    ArrayList<Integer> ImageIds = new ArrayList<>(Arrays.asList(

            R.drawable.button_home,R.drawable.button_home,R.drawable.button_home
    ));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);

        GridView gridView = findViewById(R.id.MyGrid);
        gridView.setAdapter(new ImageAdapter(ImageIds,this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int item_pos = ImageIds.get(position);

            }
        });
    }

    public void showDialogBox(final int item_pos){
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);

        TextView Image_name = dialog.findViewById(R.id.txt_Image_name);
        ImageView Image = dialog.findViewById(R.id.img);
        Button btn_Full = dialog.findViewById(R.id.btn_full);
        Button btn_Close = dialog.findViewById(R.id.btn_close);

        String title = getResources().getResourceName(item_pos);

        int index = title.indexOf("/");
        String name = title.substring(index+1,title.length());
        Image_name.setText(name);

        Image.setImageResource(item_pos);

        btn_Close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btn_Full.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Photos.this,FullView.class);
                i.putExtra("image_id",item_pos);
                startActivity(i);
            }
        });

        dialog.show();
    }
}
