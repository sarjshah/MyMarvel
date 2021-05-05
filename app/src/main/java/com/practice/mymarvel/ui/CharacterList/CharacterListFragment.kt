package com.practice.mymarvel.ui.characterlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.practice.mymarvel.R
import com.practice.mymarvel.databinding.FragmentCharacterListBinding
import com.practice.mymarvel.ui.CharacterList.CharacterListViewModelImpl
import com.practice.mymarvel.ui.adpater.CharacterListAdapter

class CharacterListFragment : Fragment() {

    private lateinit var characterListAdapter: CharacterListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentCharacterListBinding>(
            inflater,
            R.layout.fragment_character_list,
            container,
            false
        )

        val viewModel by viewModels<CharacterListViewModelImpl>()

        with(binding) {
            with(recyclerView) {
                characterListAdapter = CharacterListAdapter()
                adapter = characterListAdapter
                layoutManager = LinearLayoutManager(context)
            }

            viewModel.characterList.observe(viewLifecycleOwner, Observer {
                characterListAdapter.characterList = it
            })
        }

        return binding.root
    }
}
