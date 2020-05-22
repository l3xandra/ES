package com.example.instaplus;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class TakePictureActivity extends AppCompatActivity {

    private ImageView photoView;
    private static final int REQUEST_PHOTO_CAPTURE= 101;
    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        takePicture();
    }

    @TargetApi(Build.VERSION_CODES.M)
    public void takePicture(){

        if((checkSelfPermission(Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED)) {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                try {
                    startActivityForResult(takePictureIntent, REQUEST_PHOTO_CAPTURE);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        else{
            if(shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)){
                Toast.makeText(this, "Camera permission is needed to show the camera preview.", Toast.LENGTH_SHORT).show();
            }

            requestPermissions(new String[]{Manifest.permission.CAMERA}, REQUEST_PHOTO_CAPTURE);
        }

    }

    @SuppressLint("MissingSuperCall")
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_PHOTO_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            showAndEditPhoto(imageBitmap);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    protected void showAndEditPhoto(Bitmap img){

        Intent intent = new Intent(this, ApplyFilterPhotoActivity.class);

        intent.putExtra("newImage",img);
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS: {
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
