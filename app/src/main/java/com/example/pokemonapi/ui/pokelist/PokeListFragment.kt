package com.example.pokemonapi.ui.pokelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.pokemonapi.data.repository.PokeListRepository
import com.example.pokemonapi.databinding.FragmentPokeListBinding
import com.example.pokemonapi.domain.core.Result
import com.example.pokemonapi.ui.viewModel.PokemonViewModel
import com.example.pokemonapi.ui.viewModel.PokemonViewModelFactory

class PokeListFragment : Fragment() {

    private lateinit var binding: FragmentPokeListBinding

    private val viewModel by viewModels<PokemonViewModel> {
        PokemonViewModelFactory(
            PokeListRepository(

            )
        )
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPokeListBinding.bind(view)

        viewModel.fetchPokemon().observe(viewLifecycleOwner, Observer {
            result -> when(result) {
                is Result.Loading -> {}
            is Result.Success ->{val pokemons = result.data.results}
            is Result.Failure -> {}
            }
        })
    }


}