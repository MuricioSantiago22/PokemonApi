package com.example.pokemonapi.ui.pokelist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokemonapi.R
import com.example.pokemonapi.data.model.PokemonResult
import com.example.pokemonapi.data.repository.PokeListRepository
import com.example.pokemonapi.databinding.FragmentPokeListBinding
import com.example.pokemonapi.domain.core.Result
import com.example.pokemonapi.ui.adapter.PokeListAdapter
import com.example.pokemonapi.ui.viewModel.PokeInfoViewModel
import com.example.pokemonapi.ui.viewModel.PokeListViewModel
import com.example.pokemonapi.ui.viewModel.PokeListViewModelFactory

class PokeListFragment : Fragment(R.layout.fragment_poke_list),
    PokeListAdapter.OnPokemonListClickListener {

    private lateinit var binding: FragmentPokeListBinding
    private lateinit var adapter: PokeListAdapter

    private val viewModel by viewModels<PokeListViewModel> {
        PokeListViewModelFactory(
            PokeListRepository(

            )
        )
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPokeListBinding.bind(view)

        viewModel.fetchPokemon().observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Result.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Result.Success -> {
                    binding.progressBar.visibility = View.GONE
                    val pokemons = result.data.results
                    Log.d("LiveData", "${result.data}")
                    initRecyclerView(pokemons)
                }
                is Result.Failure -> {
                    binding.progressBar.visibility = View.GONE
                    Log.d("Error", "${result.exception}")
                }
            }
        })
    }

    private fun initRecyclerView(list: List<PokemonResult>?) {
        list?.let { _list ->
            adapter = PokeListAdapter(pokemonList = _list, itemClickListener = this)
            binding.pokelistRecyclerView.layoutManager = LinearLayoutManager(context)
            binding.pokelistRecyclerView.adapter = adapter
        }
    }

    override fun onPokemonListClick(pokemonResult: PokemonResult) {

        val action = PokeListFragmentDirections.actionPokeListFragmentToPokeInfoFragment()
        findNavController().navigate(action)
    }


}