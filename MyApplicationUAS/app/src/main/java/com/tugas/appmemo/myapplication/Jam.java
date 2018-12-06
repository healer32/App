package com.tugas.appmemo.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;

public class Jam extends AppCompatActivity {
    TextClock jamdigital;
    Button tomboljam;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jam);

        TextClock jam1 = (TextClock)findViewById(R.id.jam1);
        button2 = (Button) findViewById(R.id.button2);
        jamdigital = (TextClock)findViewById(R.id.jam2);
        jamdigital.setVisibility(View.INVISIBLE);
        tomboljam = (Button)findViewById(R.id.button1);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Jam.this, MainActivity.class));
                finish();
            }
        });
    }
    public void showTextClock(View view){
        jamdigital.setVisibility(view.VISIBLE);
        tomboljam.setText("Tampilkan Jam Digital");
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Jam.this, MainActivity.class));
        finish();
    }
}