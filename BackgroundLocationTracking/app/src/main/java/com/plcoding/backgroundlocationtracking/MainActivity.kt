package com.plcoding.backgroundlocationtracking

import android.Manifest
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import com.plcoding.backgroundlocationtracking.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION,), 0)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.start.setOnClickListener {
            val intent = Intent(applicationContext, LocationService::class.java).apply { action = LocationService.ACTION_START }
            startService(intent)
        }

        binding.stop.setOnClickListener {
            val intent = Intent(applicationContext, LocationService::class.java).apply { action = LocationService.ACTION_STOP }
            startService(intent)
        }

    }
}