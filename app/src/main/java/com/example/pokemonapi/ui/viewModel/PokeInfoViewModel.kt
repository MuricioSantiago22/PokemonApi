package com.example.pokemonapi.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.pokemonapi.data.repository.PokeInfoRepository
import com.example.pokemonapi.data.repository.PokeListRepository
import com.example.pokemonapi.domain.core.Result
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class PokeInfoViewModel(private val repo: PokeInfoRepository):ViewModel() {
    fun showPokemon(id:Int) = liveData(Dispatchers.IO){
        emit(Result.Loading())
        kotlin.runCatching {
            repo.getAllPokemonInfo(id)
        }.onSuccess { pokemon->
            emit(pokemon)
        }.onFailure { throwable ->
            emit(Result.Failure(Exception(throwable.message)))
        }
    }
}

class PokeInfoViewModelFactory(private val repo: PokeInfoRepository) :ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(PokeInfoRepository::class.java).newInstance(repo)
    }
}