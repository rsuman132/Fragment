package com.rs132studio.fragment

import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.util.*

class ShowLocation : AppCompatActivity(), OnMapReadyCallback {


    private var mMap: GoogleMap? = null
    val LOCATION_PERMISSION_REQUEST = 101
    private lateinit var mFusedLocationClient : FusedLocationProviderClient
    private lateinit var location : Location
    private lateinit var geocoder: Geocoder


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_location)

        fetchLocation()

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)


    }

    private fun fetchLocation() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {

                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                    LOCATION_PERMISSION_REQUEST
                )
                return
            }

            var task = mFusedLocationClient.lastLocation
            task.addOnSuccessListener {
                if (location != null){
                    val mapFragment = supportFragmentManager
                        .findFragmentById(R.id.map) as SupportMapFragment
                    mapFragment.getMapAsync(this)
                }
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when(requestCode){
            LOCATION_PERMISSION_REQUEST -> if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                fetchLocation()
            }
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val latLng = LatLng(location.latitude, location.longitude)
        drawableMarker(latLng)

    }

    private fun drawableMarker(latLng: LatLng) {
        val markerOptions = MarkerOptions().position(latLng).title(getAddress(latLng.latitude, latLng.longitude))

        mMap?.animateCamera(CameraUpdateFactory.newLatLng(latLng))
        mMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f))
        mMap?.addMarker(markerOptions)


    }

    private fun getAddress(latitude: Double, longitude: Double): String? {
        geocoder = Geocoder(this, Locale.getDefault())
        var address = geocoder.getFromLocation(latitude, longitude, 1)
        return address[0].getAddressLine(0).toString()
    }

}
