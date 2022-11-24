package com.example.pokemonapi.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapi.data.model.Pokemon
import com.example.pokemonapi.data.model.PokemonResult
import com.example.pokemonapi.databinding.FragmentPokeListBinding
import com.example.pokemonapi.domain.core.BaseViewHolder

class PokeListAdapter(
    private val pokemonList :List<PokemonResult>,
    private val itemClickListener :OnPokemonListClickListener
): RecyclerView.Adapter<BaseViewHolder<*>>() {



    interface OnPokemonListClickListener {
        fun onPokemonListClick(pokemonRes: PokemonResult)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding =
            FragmentPokeListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = PokeListViewHolder(itemBinding, parent.context)

        itemBinding.root.setOnClickListener {
            val position =
                holder.bindingAdapterPosition.takeIf { it != DiffUtil.DiffResult.NO_POSITION }
                    ?: return@setOnClickListener
            itemClickListener.onPokemonListClick(pokemonList[position])
        }
        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is PokeListViewHolder -> holder.bind(pokemonList[position])
        }
    }

    override fun getItemCount(): Int = pokemonList.size

    private inner class PokeListViewHolder(
        val binding : FragmentPokeListBinding, val context : Context
    ): BaseViewHolder<PokemonResult>(binding.root){
        override fun bind(item: PokemonResult) {
            val image = item.
        }
    }
}

