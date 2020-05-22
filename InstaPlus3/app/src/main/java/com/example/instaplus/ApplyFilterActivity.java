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
public class ApplyFilterActivity extends AppCompatActivity {

    Button currentButton;
    int item;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.apply_filter);

        ImageView picture = findViewById(R.id.imageSelected);

        Bundle b = getIntent().getExtras();

        item = -1; // or other values
        if(b != null)
            item = b.getInt("res");

        picture.setImageResource(item);

        Button button = findViewById(R.id.originalFilter);
        button.setBackgroundColor(Color.BLUE);
        currentButton =button;
    }

    public void originalPic(View view) {
        ImageView image = findViewById(R.id.imageSelected);
        image.setImageResource(R.drawable.rabbit);

        Button button = findViewById(R.id.originalFilter);

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
        ImageView image = findViewById(R.id.imageSelected);


        image.setImageResource(R.drawable.rabbit1);
        Button button = findViewById(R.id.filter1);

        setCurrentButton(button);
    }

    public void filter2(View view){
        ImageView image = findViewById(R.id.imageSelected);
        image.setImageResource(R.drawable.rabbit2);

        Button button = findViewById(R.id.filter2);

        setCurrentButton(button);
    }

    public void filter3(View view){
        ImageView image = findViewById(R.id.imageSelected);
        image.setImageResource(R.drawable.rabbit3);

        Button button = findViewById(R.id.filter3);

        setCurrentButton(button);
    }

    public void anterior(View view){
        startActivity(new Intent(this, MainActivity.class));
    }

    public void seguinte(View view){

        Intent intent = new Intent(this, EditarFotoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("res",item);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
