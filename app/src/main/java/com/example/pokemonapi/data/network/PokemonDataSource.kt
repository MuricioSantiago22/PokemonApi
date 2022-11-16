package com.example.pokemonapi.data.network

import androidx.lifecycle.MutableLiveData
import com.example.pokemonapi.data.model.PokemonResponse
import com.example.pokemonapi.data.model.PokemonResult
import com.example.pokemonapi.domain.core.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.*


class PokemonDataSource {

    private val retrofit= RetrofitHelper.getRetrofit()

    val pokemonList = MutableLiveData<List<PokemonResult>>()

    suspend fun getAllPokemonList() {
        return withContext(Dispatchers.IO){
            val response = retrofit.create(WebServicePokemon::class.java).getPokemonList(100, 0)
            response.enqueue(object : Callback<PokemonResponse>{
                override fun onResponse(
                    call: Call<PokemonResponse>,
                    response: Response<PokemonResponse>
                ) {
                    response.body()?.results?.let { list ->
                    pokemonList.postValue(list)

                    }
                }

                override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                    call.cancel()
                }

            })
        }
    }
}






