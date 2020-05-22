package com.example.instaplus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
public class ApplyFilterPhotoActivity extends AppCompatActivity {

    Button currentButton;
    int item;
    Bitmap img;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.apply_filter_photo);

        ImageView picture = findViewById(R.id.imageTaken);

        img = (Bitmap) getIntent().getParcelableExtra("newImage");

        picture.setImageBitmap(img);

        Button button = findViewById(R.id.originalFilter1);
        button.setBackgroundColor(Color.BLUE);
        currentButton =button;
    }

    public void originalPic(View view) {
        ImageView image = findViewById(R.id.imageTaken);
        image.setImageResource(R.drawable.rabbit);

        Button button = findViewById(R.id.originalFilter1);

        setCurrentButton(button);
    }

    public void setCurrentButton(Button button){
        if (button != currentButton) {
            button.setBackgroundColor(Color.BLUE);
            currentButton.setBackgroundColor(Color.WHITE);
            currentButton = button;
        }
    }

    public void filter1(View view){
        ImageView image = findViewById(R.id.imageTaken);
        image.setImageResource(R.drawable.rabbit1);
        Button button = findViewById(R.id.filter12);

        setCurrentButton(button);
    }

    public void filter2(View view){
        ImageView image = findViewById(R.id.imageTaken);
        image.setImageResource(R.drawable.rabbit2);

        Button button = findViewById(R.id.filter22);

        setCurrentButton(button);
    }

    public void filter3(View view){
        ImageView image = findViewById(R.id.imageTaken);
        image.setImageResource(R.drawable.rabbit3);

        Button button = findViewById(R.id.filter32);

        setCurrentButton(button);
    }

    public void anterior(View view){
        startActivity(new Intent(this, MainActivity.class));
    }

    public void seguinte(View view){

        Intent intent = new Intent(this, EditNewPhotoActivity.class);
        intent.putExtra("newImage",img);
        startActivity(intent);
    }
}
