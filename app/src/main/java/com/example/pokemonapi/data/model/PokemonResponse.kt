package com.example.pokemonapi.data.model


import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    @SerializedName("count")val count:Int? = null,
    @SerializedName("next")val next: String? = null,
    @SerializedName("previous")val previous : String? = null,
    @SerializedName("results")val results : List<PokemonResult>? = null
)
