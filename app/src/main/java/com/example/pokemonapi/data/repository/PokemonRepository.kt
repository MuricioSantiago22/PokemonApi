package com.example.pokemonapi.data.repository

import com.example.pokemonapi.data.model.PokemonResponse
import com.example.pokemonapi.data.network.PokemonDataSource
import com.example.pokemonapi.domain.core.Result

class PokemonRepository {

    private val pokemonDS = PokemonDataSource()

    suspend fun getAllPokemon():Result<PokemonResponse>{
        return  pokemonDS.getAllPokemon()
    }
}