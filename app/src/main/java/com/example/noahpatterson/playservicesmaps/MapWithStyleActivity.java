package com.example.noahpatterson.playservicesmaps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MapWithStyleActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap map;
    boolean mapReady = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_with_style);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //regular map
        Button mapViewButton = (Button) findViewById(R.id.mapViewButton);
        mapViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady) {
                    map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                }
            }
        });

        //satellite map
        Button satelliteViewButton = (Button) findViewById(R.id.satelliteViewButton);
        satelliteViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady) {
                    map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                }
            }
        });

        //hybird map
        Button hybirdViewButton = (Button) findViewById(R.id.hybridViewButton);
        hybirdViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady) {
                    map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                }
            }
        });
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        mapReady = true;
        LatLng newYorkLatLng = new LatLng(40.7484,-73.9857);
        CameraPosition cameraPosition = CameraPosition.builder().target(newYorkLatLng).zoom(14).build();
        map.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }
}
