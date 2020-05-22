package com.example.instaplus;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class EditVideoActivity extends AppCompatActivity {

    Bitmap video;

    private static final String[] LOCATIONS = new String[]{
            "FCT UNL",
            "Monte de Caparica, Almada",
            "Costa da Caparica, Almada",
            "Forum Almada"
    };

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_video);


        AutoCompleteTextView edtiLocation = findViewById(R.id.localizacaoAutoComplete);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, LOCATIONS);

        edtiLocation.setAdapter(adapter);
    }

    public void goBack(View view){
        Intent intent = new Intent(this, TakeVideoActivity.class);
        startActivity(intent);
    }
}
