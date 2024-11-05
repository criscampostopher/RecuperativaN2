package cl.ipvg.recuperativon2;

import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import cl.ipvg.recuperativon2.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private String stLatutudN1="",stLatutudN2="",stLatutudN3="",stLongitudN1="",stLongitudN2="",stLongitudN3="";
    Double LatutudN1,LatutudN2,LatutudN3,LongitudN1,LongitudN2,LongitudN3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        stLatutudN1= getIntent().getStringExtra("LatitudN1");
        stLatutudN2= getIntent().getStringExtra("LatitudN2");
        stLatutudN3= getIntent().getStringExtra("LatitudN3");

        LatutudN1=Double.parseDouble(stLatutudN1);
        LatutudN2=Double.parseDouble(stLatutudN2);
        LatutudN3=Double.parseDouble(stLatutudN3);

        stLongitudN1= getIntent().getStringExtra("LongitudN1");
        stLongitudN2= getIntent().getStringExtra("LongitudN2");
        stLongitudN3= getIntent().getStringExtra("LongitudN3");

        LongitudN1=Double.parseDouble(stLongitudN1);
        LongitudN2=Double.parseDouble(stLongitudN2);
        LongitudN3=Double.parseDouble(stLongitudN3);

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

        // Add a marker in Sydney and move the camera
        LatLng DireccionN1 = new LatLng(LatutudN1, LongitudN1);
        LatLng DireccionN2 = new LatLng(LatutudN2, LongitudN2);
        LatLng DireccionN3 = new LatLng(LatutudN3, LongitudN3);
        mMap.addMarker(new MarkerOptions().position(DireccionN1).title("PLAZA_BULNES"));
        mMap.addMarker(new MarkerOptions().position(DireccionN2).title("COPEC"));
        mMap.addMarker(new MarkerOptions().position(DireccionN3).title("COMISARIA"));


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(DireccionN1,100));
    }
}