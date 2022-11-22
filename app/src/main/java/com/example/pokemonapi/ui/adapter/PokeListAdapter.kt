package com.example.pokemonapi.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapi.data.model.Pokemon
import com.example.pokemonapi.data.model.PokemonResult
import com.example.pokemonapi.domain.core.BaseViewHolder

class PokeListAdapter(
    private val pokemonList :List<PokemonResult>,
    private val itemClickListener :OnProductListClickListener
): RecyclerView.Adapter<BaseViewHolder<*>>() {



    interface OnProductListClickListener {
        fun onProductListClick(pokemonRes: PokemonResult)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding =
            ItemProductListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = PokeListViewHolder(itemBinding, parent.context)

        itemBinding.root.setOnClickListener {
            val position =
                holder.bindingAdapterPosition.takeIf { it != DiffUtil.DiffResult.NO_POSITION }
                    ?: return@setOnClickListener
            itemClickListener.onProductListClick(listProduct[position])
        }
        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is PokeListViewHolder -> holder.bind(pokemonList[position])
        }
    }

    override fun getItemCount(): Int = pokemonList.size
}

private inner class PokeListViewHolder()
