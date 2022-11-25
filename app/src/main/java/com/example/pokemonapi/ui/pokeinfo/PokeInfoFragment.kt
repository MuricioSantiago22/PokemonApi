package com.example.pokemonapi.ui.pokeinfo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pokemonapi.R
import com.example.pokemonapi.databinding.FragmentPokeInfoBinding

class PokeInfoFragment : Fragment() {

    private lateinit var binding: FragmentPokeInfoBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPokeInfoBinding.bind(view)
    }

}