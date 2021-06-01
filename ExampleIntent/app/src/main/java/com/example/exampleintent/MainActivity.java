package com.example.exampleintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //Declare the views.
    EditText name,number,link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initialise the views here
        name = findViewById(R.id.name);
        number = findViewById(R.id.number);
        link = findViewById(R.id.link);
    }

    public void next(View view) {
        //Here we will work with explicit intent.
        String n = name.getText().toString();
        //Intent obj = new Intent(present class,next class)
        //startActivity(obj);
        Intent i = new Intent(this,SecondActivity.class);
        i.putExtra("key",n);
        startActivity(i);
    }

    public void dial(View view) {
        //Here we will work with Implicit Intent.
        String n = number.getText().toString();
        //URI - Unified Resource Identifier
        Uri uri = Uri.parse("tel:"+n);
        Intent i = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(i);
    }

    public void search(View view) {
        //Here we will work with Implicit Intent.
        String n = link.getText().toString();
        //URI - Unified Resource Identifier
        Uri uri = Uri.parse("https://"+n);
        Intent i = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(i);
    }
}