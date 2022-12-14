package com.example.pokemonapi.data.network
import androidx.lifecycle.MutableLiveData
import com.example.pokemonapi.data.model.Pokemon
import com.example.pokemonapi.data.model.PokemonResponse
import com.example.pokemonapi.data.model.PokemonResult
import com.example.pokemonapi.domain.core.Result
import com.example.pokemonapi.domain.core.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.*


class PokeListDataSource {

    private val retrofit= RetrofitHelper.getRetrofit()

    suspend fun getAllPokemon():Result<List<Pokemon>>{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(WebServicePokemon::class.java).getPokemonList(450, 0)
            val pokemonList = response.body() as PokemonResponse
            val pokemonListParsed = mutableListOf<Pokemon>()
            pokemonList.results?.forEachIndexed { index, pokemonResult ->
                val pokemon = Pokemon(
                    id = index + 1,
                    pokemonResult.name
                )
                pokemonListParsed.add(pokemon)
            }
            Result.Success(pokemonListParsed)
        }
    }
}






