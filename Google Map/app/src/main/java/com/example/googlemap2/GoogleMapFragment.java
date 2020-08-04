package com.example.googlemap2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GoogleMapFragment extends Fragment implements OnMapReadyCallback {

    View view;
    MapView my_mapView;
    GoogleMap gMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_google_map, container, false);

        my_mapView = view.findViewById(R.id.my_mapView);
        my_mapView.onCreate(savedInstanceState);
        my_mapView.onResume();

        // MapView'i çalıştırma ->
        my_mapView.getMapAsync(GoogleMapFragment.this);

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;
        LatLng latLng = new LatLng(37.0331905,34.6755136);
        gMap.addMarker(new MarkerOptions().position(latLng).title("Pirömerli Köyü"));
    }

}