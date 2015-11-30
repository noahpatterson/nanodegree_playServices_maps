package com.example.noahpatterson.playservicesmaps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openBasicMap(View view) {
        Intent intent = new Intent(this, BasicMapActivity.class);
        startActivity(intent);
    }

    public void openMapWithStyle(View view) {
        Intent intent = new Intent(this, MapWithStyleActivity.class);
        startActivity(intent);
    }

    public void openAnimatedMap(View view) {
        Intent intent = new Intent(this, AnimateCameraMap.class);
        startActivity(intent);
    }

    public void openStreetView(View view) {
        Intent intent = new Intent(this, StreetViewActivity.class);
        startActivity(intent);
    }
}
