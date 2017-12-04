package com.example.pak.studentsprojectdemo;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Maps extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment fragment=(SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_frgmnt);
        fragment.getMapAsync(this);
    }

        @Override
        public void onMapReady(GoogleMap googleMap) {
            mMap = googleMap;

            // Add a marker in Sydney and move the camera
            LatLng cantonment = new LatLng(32.0803,72.6763 );
            mMap.addMarker(new MarkerOptions().position(cantonment).title("Cantonment Board Sargodha"));


//---------------------set camera-----
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(infosys));
//        LatLng pos=new LatLng(32.0796,72.6835);
//        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(pos, 19.0f));
            //--------------------------------------------------------------------

            //------------another camera code------------------------------
            CameraPosition cameraPosition = new CameraPosition.Builder().target(cantonment).zoom(18).build();
            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        }

}
