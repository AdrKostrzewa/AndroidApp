package com.example.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class kontakt_fragment extends Fragment implements OnMapReadyCallback
        {
            GoogleMap mgoogleMap;
            View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_kontakt_fragment,container,false);
        wlaczMapy();
        return rootView;
        // Inflate the layout for this fragment

    }

            @Override
            public void onMapReady(GoogleMap googleMap) {
                mgoogleMap = googleMap;
                idzDoLokalizacji(51.76639848106245, 19.456874746035226,  15);
            }

            private void idzDoLokalizacji(double szerokosc, double dlugosc, float zoom) {

                LatLng ll = new LatLng(szerokosc, dlugosc);
                mgoogleMap.addMarker(new MarkerOptions().position(ll).title("Gastro Machina"));

                CameraUpdate update = CameraUpdateFactory.newLatLngZoom(ll, zoom);
                mgoogleMap.moveCamera(update);
            }

            private void wlaczMapy() {
        SupportMapFragment mapFragment=(SupportMapFragment)  getChildFragmentManager().findFragmentById(R.id.mapfragment);
                mapFragment.getMapAsync(this);

            }

}
