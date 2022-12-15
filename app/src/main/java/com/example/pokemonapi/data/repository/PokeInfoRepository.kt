package com.example.pokemonapi.data.repository

import com.example.pokemonapi.data.model.Pokemon
import com.example.pokemonapi.data.network.PokeInfoDataSource
import com.example.pokemonapi.domain.core.Result


class PokeInfoRepository {

    private val pokemonInfDS = PokeInfoDataSource()

    suspend fun getAllPokemonInfo(): Result<Pokemon> {
        return pokemonInfDS.getAllPokemonInfo()
    }
}