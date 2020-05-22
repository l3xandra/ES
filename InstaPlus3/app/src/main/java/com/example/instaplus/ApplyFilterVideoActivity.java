package com.example.instaplus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;

import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class ApplyFilterVideoActivity extends AppCompatActivity {

    Button currentButton;
    int item;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.apply_filter_video);

        VideoView video = findViewById(R.id.videoTaken);

        Uri uri = (Uri) getIntent().getParcelableExtra("newVideo");

        video.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);

        video.setMediaController(new MediaController(this) {
            @Override
            public void hide()
            {
                show();
            }

        });

        video.start();

    }

    public void anterior(View view){
        startActivity(new Intent(this, MainActivity.class));
    }

    public void seguinte(View view){

        Intent intent = new Intent(this, EditarFotoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("res2",item);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
