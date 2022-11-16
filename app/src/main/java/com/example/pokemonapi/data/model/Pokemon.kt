package com.example.pokemonapi.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Pokemon(@SerializedName("id")val id :Int? = null,
                   @SerializedName("name")val name: String? = null,
                   @SerializedName("weight")val weight: Int? = null,
                   @SerializedName("height")val height: Int? = null,
                   @SerializedName("sprites")val sprites:Sprites? = null
)

data class Sprites( @SerializedName("front_default")val frontDefault: String? = null,
                    @SerializedName("front_shiny")val frontShiny: String?= null)
