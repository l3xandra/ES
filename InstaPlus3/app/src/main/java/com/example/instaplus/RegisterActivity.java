package com.example.instaplus;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_main);


    }


    public void register(View view){
        EditText pass1 = findViewById(R.id.insertPass);
        EditText pass2 = findViewById(R.id.insertPass2);

        if(!pass1.getText().toString().equals(pass2.getText().toString())) {
            String sentence = "As palavras passe não são idênticas";
            TextView errorMsg = findViewById(R.id.errorMessage);
            errorMsg.setText(sentence);

        }
        else{

            setContentView(R.layout.register_date);
        }
    }

    public void showCross(View view){

        TextView username = findViewById(R.id.createUsername);
       
    }
}
