package com.example.pokemonapi.ui.viewModel

import androidx.lifecycle.*
import com.example.pokemonapi.data.repository.PokemonRepository
import com.example.pokemonapi.domain.core.Result
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class PokemonViewModel(private val repo: PokemonRepository): ViewModel() {
    fun fetchPokemon() = liveData(Dispatchers.IO){
        emit(Result.Loading())
        kotlin.runCatching {
            repo.getAllPokemon()
        }.onSuccess { pokemonResponse->
            emit(pokemonResponse)
        }.onFailure { throwable ->
            emit(Result.Failure(Exception(throwable.message)))
        }
    }
}


class PokemonViewModelFactory(private val repo:PokemonRepository ) :ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(PokemonRepository::class.java).newInstance(repo)
    }
}


