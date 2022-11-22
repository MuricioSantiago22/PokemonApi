package com.example.pokemonapi.ui.viewModel

import androidx.lifecycle.*
import com.example.pokemonapi.data.repository.PokeListRepository
import com.example.pokemonapi.domain.core.Result
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class PokemonViewModel(private val repo: PokeListRepository): ViewModel() {
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


class PokemonViewModelFactory(private val repo:PokeListRepository ) :ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(PokeListRepository::class.java).newInstance(repo)
    }
}


