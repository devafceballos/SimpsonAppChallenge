package com.example.simpsonappchallenge.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter

import androidx.recyclerview.widget.RecyclerView
import com.example.simpsonappchallenge.R
import com.example.simpsonappchallenge.databinding.ItemViewHolderBinding
import com.example.simpsonappchallenge.model.SimpsonSimpleCharacter

class CharacterAdapter(private val simpsonsCharacterList: List<SimpsonSimpleCharacter.DataSimple>,
                       private val onClickListener: (SimpsonSimpleCharacter.DataSimple) -> Unit): RecyclerView.Adapter <CharacterAdapter.SimpsonHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterAdapter.SimpsonHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SimpsonHolder(layoutInflater.inflate(R.layout.item_view_holder, parent, false))
    }

    override fun onBindViewHolder(holder: SimpsonHolder, position: Int) {
        val item = simpsonsCharacterList[position]
        holder.render(item)

        holder.itemView.setOnClickListener {
            onClickListener(item)
        }
    }

    override fun getItemCount(): Int = simpsonsCharacterList.size

    //Holder Inner Class
    class SimpsonHolder(view: View): RecyclerView.ViewHolder(view) {

        private val binding = ItemViewHolderBinding.bind(view)

        fun render(item: SimpsonSimpleCharacter.DataSimple){
            binding.tvName.text = item.name
            binding.tvLastName.text = item.lastname

        }
    }
}