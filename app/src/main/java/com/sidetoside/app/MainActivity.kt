package com.sidetoside.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.sidetoside.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).also {
            binding = it
        }

        setupActionBarWithNavController(
            findNavController(R.id.nav_host_fragment).apply {
                setupActionBarWithNavController(
                    this,
                    AppBarConfiguration(setOf(R.id.navigation_home))
                )
            })
    }
}

