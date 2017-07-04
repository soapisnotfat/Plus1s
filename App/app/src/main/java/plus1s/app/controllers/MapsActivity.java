package plus1s.app.controllers;

import android.app.AlertDialog;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Map;

import plus1s.app.R;
import plus1s.app.model.Item;
import plus1s.app.model.UserDetails;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
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

//        Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        ArrayList<Item> e = new ArrayList<>();
        for (Map.Entry<String, Item> entry: UserDetails.getCurrentUser().getItems().entrySet()) {
            e.add(entry.getValue());
        }
        for (Item i : e) {
            LatLng location = new LatLng(i.getLongitude(), i.getLatitude());
            Marker amaker = mMap.addMarker(new MarkerOptions().position(location).title("This is " + i.getName()));
            amaker.setTag(i);
            mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
        }
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Item thisItem = (Item)(marker.getTag());
                AlertDialog.Builder dialog3 = new AlertDialog.Builder(MapsActivity.this);
                dialog3.setTitle("This item is " + thisItem.getName());
                dialog3.setMessage("The uploader is " + thisItem.getUploader())
                        .setNegativeButton("Get it", null)
                        .create()
                        .show();
                return false;
            }
        });
    }
}
