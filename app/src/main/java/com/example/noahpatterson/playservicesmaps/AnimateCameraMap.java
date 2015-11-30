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
import com.google.android.gms.maps.model.MarkerOptions;

public class AnimateCameraMap extends AppCompatActivity implements OnMapReadyCallback{
    private GoogleMap googleMap;
    private Boolean mapReady;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animate_camera_map);

        //new york button
        Button newYorkButton = (Button) findViewById(R.id.newYorkButton);
        newYorkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady) {
                    LatLng newYorkLatLng = new LatLng(40.7127, -74.0059);
                    MarkerOptions markerOptions = new MarkerOptions().position(newYorkLatLng).title("New York");
                    CameraPosition cameraPosition = CameraPosition.builder()
                            .target(newYorkLatLng)
                            .zoom(14)
                            .build();
                    googleMap.addMarker(markerOptions);
                    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition), 3000, null);
                }
            }
        });

        //seattle button
        Button seattleButton = (Button) findViewById(R.id.seattleButton);
        seattleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady) {
                    LatLng seattleLatLng = new LatLng(47.6204, -122.491);
                    CameraPosition cameraPosition = CameraPosition.builder()
                            .target(seattleLatLng)
                            .zoom(14)
                            .build();
                    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition),3000, null);
                }
            }
        });

        //asheville button
        Button ashevilleButton = (Button) findViewById(R.id.ashevilleButton);
        ashevilleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady) {
                    LatLng ashevilleLatLng = new LatLng(35.5963, -82.5551);
                    CameraPosition cameraPosition = CameraPosition.builder()
                            .target(ashevilleLatLng)
                            .zoom(14)
                            .build();
                    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition),3000, null);
                }
            }
        });

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        mapReady = true;
    }
}
