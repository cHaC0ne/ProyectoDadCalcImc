package com.example.nuevoproyect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import com.example.nuevoproyect.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        b.bNaVi.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bDados -> {
                    Navigation.findNavController(b.fragmentContainerView)
                        .navigate(R.id.firstFragment)
                    true

                }
                R.id.bCalculadora -> {
                    Navigation.findNavController(b.fragmentContainerView)
                        .navigate(R.id.secondFragment)
                    true
                }
                R.id.bImc -> {
                    Navigation.findNavController(b.fragmentContainerView)
                        .navigate(R.id.thirdFragment)
                    true
                }
                else -> false
            }
        }

    }
}