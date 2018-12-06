package com.tugas.appmemo.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    private Button btn_calculator, btn_jam, btn_logout;
    String id, username;
    SharedPreferences sharedpreferences;

    public static final String TAG_ID = "id";
    public static final String TAG_USERNAME = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_calculator = (Button) findViewById(R.id.btn_calculator);
        btn_jam = (Button) findViewById(R.id.btn_jam);
        btn_logout = (Button) findViewById(R.id.btn_logout);

        sharedpreferences = getSharedPreferences(LoginActivity.my_shared_preferences, Context.MODE_PRIVATE);

        id = getIntent().getStringExtra(TAG_ID);
        username = getIntent().getStringExtra(TAG_USERNAME);

        btn_jam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Jam.class));
                finish();
            }
        });
        btn_calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Calculator.class));
                finish();
            }
        });
        btn_logout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(LoginActivity.session_status, false);
                editor.putString(TAG_ID, null);
                editor.putString(TAG_USERNAME, null);
                editor.commit();

                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                finish();
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent a = new Intent(Intent.ACTION_MAIN);
                        a.addCategory(Intent.CATEGORY_HOME);
                        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(a);

                        onBackPressed();
                        finish();
                    }
                }).create().show();
    }
}
