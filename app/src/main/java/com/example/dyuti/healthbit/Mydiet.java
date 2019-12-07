package com.example.dyuti.healthbit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Mydiet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydiet);
        Intent i = new Intent(Mydiet.this,Chat.class);
        startActivity(i);
    }
}
