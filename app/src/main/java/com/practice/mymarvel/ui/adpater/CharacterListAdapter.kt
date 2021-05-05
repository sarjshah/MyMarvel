package com.practice.mymarvel.ui.adpater

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.practice.bbapplication.model.CharacterResponse
import com.practice.mymarvel.R
import com.practice.mymarvel.databinding.ItemCharacterBinding

class CharacterListAdapter : RecyclerView.Adapter<CharacterListAdapter.CharacterListViewHolder>() {

    var characterList: List<CharacterResponse> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterListViewHolder {
        return CharacterListViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.item_character, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: CharacterListViewHolder, position: Int) {
        holder.bind(characterList[position])
    }

    override fun getItemCount() = characterList.size

    class CharacterListViewHolder(val itemViewBinding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(itemViewBinding.root) {
        fun bind(character: CharacterResponse) {
            itemViewBinding.character = character
        }
    }
}