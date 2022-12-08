package com.example.pokemonapi.data.repository

import com.example.pokemonapi.data.model.Pokemon
import com.example.pokemonapi.data.model.PokemonResponse
import com.example.pokemonapi.data.network.PokeListDataSource
import com.example.pokemonapi.domain.core.Result

class PokeListRepository {

    private val pokemonDS = PokeListDataSource()

    suspend fun getAllPokemon():Result<List<Pokemon>>{
        return  pokemonDS.getAllPokemon()
    }
}