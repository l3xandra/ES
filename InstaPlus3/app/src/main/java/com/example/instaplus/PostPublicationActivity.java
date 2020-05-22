package com.example.instaplus;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class PostPublicationActivity extends AppCompatActivity {

    GridView galeria;
    int selectedImageId;
    ImageView lastImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        galeria = (GridView)findViewById(R.id.galeria);
        //galeria.setLayoutParams(new GridView.LayoutParams(GridView.AUTO_FIT, 100));
        galeria.setAdapter(new ImageAdapter(this));

    }

    public void showImage(int img){
        Intent intent = new Intent(this, ApplyFilterActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("res",img);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @TargetApi(Build.VERSION_CODES.M)
    public void takePicture(View view){

        startActivity(new Intent(this, TakePictureActivity.class));

    }

    @TargetApi(Build.VERSION_CODES.M)
    public void takeVideo(View view){

        startActivity(new Intent(this, TakeVideoActivity.class));

    }
}
