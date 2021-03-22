package com.seloger.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.seloger.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findNavController(R.id.fragmentContainer).addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.splashFragment -> {
                    supportActionBar?.hide()
                }
                R.id.homeFragment -> {
                    supportActionBar?.show()
                }
                R.id.announcementDetailsFragment -> {
                    supportActionBar?.hide()
                }
            }
        }
    }
}