package com.example.pokemonapi.data.network

import com.example.pokemonapi.data.model.Pokemon
import com.example.pokemonapi.domain.core.Result
import com.example.pokemonapi.domain.core.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.LoggingEventListener
import retrofit2.Response

class PokeInfoDataSource {


    private val retrofit= RetrofitHelper.getRetrofit()

     suspend fun getAllPokemonInfo(): Result<Pokemon> {
        return withContext(Dispatchers.IO){
            val response= retrofit.create(WebServicePokemon::class.java).getPokemonInfo(1)
            Result.Success(response.body()?: Pokemon())
        }
    }

}