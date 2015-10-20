package com.example.mapsexample;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Marker in Universidad Panamericana
        LatLng bona = new LatLng(21.8236981, -102.2861846);

        // 1) Simple marker
//        mMap.addMarker(new MarkerOptions()
//                .position(bona)
//                .title("Marker en la Bonaterra")
//                .snippet("La Universidad donde tomamos clases"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(bona));

        // 2) Map type
//        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        // 3) Custom marker
        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.star))
                .position(bona)
                .title("Marker en la Bonaterra")
                .snippet("La Universidad donde tomamos clases"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bona, 14));

        // 4) Draw shapes
        CircleOptions circleOptions = new CircleOptions()
                .center(bona)   //set center
                .radius(200)   //set radius in meters
                .fillColor(0x220000FF)  //translucent blue
                .strokeColor(Color.BLUE) // blue
                .strokeWidth(2);

        mMap.addCircle(circleOptions);

        // Homework
//        mMap.addPolygon(new PolygonOptions());
//        mMap.addPolyline(new PolylineOptions());
    }
}
