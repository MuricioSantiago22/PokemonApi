package com.example.pokemonapi.data.model

import com.google.gson.annotations.SerializedName

data class Pokemon( @SerializedName("id")val id :Int,
                    @SerializedName("name")val name: String,
                    @SerializedName("weight")val weight: Int,
                    @SerializedName("height")val height: Int,
                    @SerializedName("sprites")val sprites:Sprites
)

data class Sprites(@SerializedName("front_default")val frontDefault: String?,
                   @SerializedName("front_shiny")val frontShiny: String?)
