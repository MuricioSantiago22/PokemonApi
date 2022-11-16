package com.example.pokemonapi.data.network

import com.example.pokemonapi.data.model.Pokemon
import com.example.pokemonapi.data.model.PokemonResponse
import com.example.pokemonapi.data.model.PokemonResult
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WebServicePokemon {
    @GET("pokemon/{id}")
    suspend fun getPokemonInfo(@Path("id") id: Int): Response<Pokemon>

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Response<PokemonResponse>
}