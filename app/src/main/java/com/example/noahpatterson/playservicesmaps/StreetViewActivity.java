package com.example.noahpatterson.playservicesmaps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public class StreetViewActivity extends AppCompatActivity implements OnStreetViewPanoramaReadyCallback {
    StreetViewPanorama streetViewPanorama;
    Boolean mapReady = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_street_view);

        StreetViewPanoramaFragment streetViewPanoramaFragment = (StreetViewPanoramaFragment) getFragmentManager().findFragmentById(R.id.map);
        streetViewPanoramaFragment.getStreetViewPanoramaAsync(this);
    }


    @Override
    public void onStreetViewPanoramaReady(StreetViewPanorama streetViewPanorama) {
        this.streetViewPanorama = streetViewPanorama;
        mapReady = true;
        streetViewPanorama.setPosition(new LatLng(36.0579667,-112.1430996));
        StreetViewPanoramaCamera camera = StreetViewPanoramaCamera.builder()
                .build();
        streetViewPanorama.animateTo(camera, 1000);
    }
}
