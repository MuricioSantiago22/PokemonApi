package com.example.pokemonapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pokemonapi.R
import com.example.pokemonapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.fragmentContainerView
    }
}