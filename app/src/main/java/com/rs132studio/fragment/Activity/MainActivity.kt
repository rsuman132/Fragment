package com.rs132studio.fragment.Activity

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.rs132studio.fragment.Adapter.FragmentAdapter
import com.rs132studio.fragment.R
import com.rs132studio.fragment.ShowLocation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    val LOCATION_PERMISSION_REQUEST = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        getLocationAccess()

        viewPager.adapter = FragmentAdapter(supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
    }


    //menu option created

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.show_location, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.show_location -> {
                val intent = Intent(this, ShowLocation::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    //Location Permission

//    private fun getLocationAccess() {
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
//            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show()
//
//            }
//            else
//                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQUEST)
//        }
//
//    }


//    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
//        if (requestCode == LOCATION_PERMISSION_REQUEST) {
//            if (grantResults.contains(PackageManager.PERMISSION_GRANTED)) {
//                Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show()
//            }
//            else {
//                Toast.makeText(this, "User has not granted location access permission", Toast.LENGTH_LONG).show()
//                finish()
//            }
//        }
//    }

    //Exit button pressed
    override fun onBackPressed() {
        if(viewPager.currentItem != 0){
            viewPager.setCurrentItem(0,false);
        }else{
            finish()
        }
    }

}