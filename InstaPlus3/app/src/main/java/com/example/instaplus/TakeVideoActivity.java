package com.example.instaplus;

import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.hardware.camera2.CameraManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

public class TakeVideoActivity extends AppCompatActivity {

    private static final int REQUEST_VIDEO_CAPTURE= 1;
    private static final int MY_PERMISSIONS_REQUEST_CAMERA =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        takePicture();
    }

    @TargetApi(Build.VERSION_CODES.M)
    public void takePicture(){

        if((checkSelfPermission(Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED)) {
            Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {
                try {
                    startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        else{
            if(shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)){
                Toast.makeText(this, "Camera permission is needed to show the camera preview.", Toast.LENGTH_SHORT).show();
            }

            requestPermissions(new String[]{Manifest.permission.CAMERA}, REQUEST_VIDEO_CAPTURE);
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){

        if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK) {
            Uri videoUri = intent.getData();

            showAndEditVideo(videoUri);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    protected void showAndEditVideo(Uri video){

        Intent intent = new Intent(this, EditVideoActivity.class);

        try {
            startActivity(intent);
        }catch(Exception e){
            System.out.println("HEREEEEEEEE " + e);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CAMERA: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }


}

