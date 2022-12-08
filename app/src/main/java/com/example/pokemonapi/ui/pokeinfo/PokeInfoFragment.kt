package com.example.pokemonapi.ui.pokeinfo

import android.os.Bundle

import androidx.fragment.app.Fragment

import android.view.View

import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.pokemonapi.R
import com.example.pokemonapi.data.repository.PokeInfoRepository
import com.example.pokemonapi.data.repository.PokeListRepository
import com.example.pokemonapi.databinding.FragmentPokeInfoBinding
import com.example.pokemonapi.domain.core.Result
import com.example.pokemonapi.ui.viewModel.PokeInfoViewModel
import com.example.pokemonapi.ui.viewModel.PokeInfoViewModelFactory
import com.example.pokemonapi.ui.viewModel.PokeListViewModel
import com.example.pokemonapi.ui.viewModel.PokeListViewModelFactory
import okhttp3.internal.wait


class PokeInfoFragment : Fragment(R.layout.fragment_poke_info) {

    private lateinit var binding: FragmentPokeInfoBinding

    private val viewModel by viewModels<PokeInfoViewModel> {
        PokeInfoViewModelFactory(
            PokeInfoRepository(

            )
        )
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPokeInfoBinding.bind(view)
        initUI()
    }
    private fun initUI(){


        viewModel.showPokemon(0).observe(viewLifecycleOwner, Observer { pokemon ->
            when(pokemon){
                is Result.Loading ->{
                    binding.pB.visibility = View.VISIBLE

                }
                is Result.Success ->{
                    binding.pB.visibility = View.GONE
                }

            }
        })

    }
}