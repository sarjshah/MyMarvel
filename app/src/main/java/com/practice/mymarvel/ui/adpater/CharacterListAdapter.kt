package com.practice.mymarvel.ui.adpater

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.practice.mymarvel.R
import com.practice.mymarvel.databinding.ItemCharacterBinding
import com.practice.mymarvel.model.MarvelCharacter

typealias CharacterOnclickListener = (MarvelCharacter) -> Unit
class CharacterListAdapter :
    RecyclerView.Adapter<CharacterListAdapter.CharacterListViewHolder>(),
    CharacterOnclickListener {

    lateinit var characterOnclickListener: CharacterOnclickListener

    var characterList: List<MarvelCharacter> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterListViewHolder {
        return CharacterListViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.item_character, parent, false
            ),
            this
        )
    }

    override fun onBindViewHolder(holder: CharacterListViewHolder, position: Int) {
        holder.bind(characterList[position])
    }

    override fun getItemCount() = characterList.size

    override fun invoke(p1: MarvelCharacter) = characterOnclickListener(p1)

    class CharacterListViewHolder(
        val itemViewBinding: ItemCharacterBinding,
        val onClickListener: CharacterOnclickListener
    ) :
        RecyclerView.ViewHolder(itemViewBinding.root) {
        fun bind(characterItem: MarvelCharacter) {
            with(itemViewBinding) {
                character = characterItem
                ivCardView.setOnClickListener {
                    onClickListener(characterItem)
                }
            }
        }
    }
}
