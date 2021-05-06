package com.practice.mymarvel.ui.characterlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.practice.mymarvel.R
import com.practice.mymarvel.data.network.CharacterRetrofitFactory
import com.practice.mymarvel.data.repository.CharacterRepositoryImpl
import com.practice.mymarvel.databinding.FragmentCharacterListBinding
import com.practice.mymarvel.internal.CharacterUIState
import com.practice.mymarvel.model.MarvelCharacter
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

        val viewModel = ViewModelProvider(
            this,
            CharacterListViewModelFactory(
                CharacterRepositoryImpl(CharacterRetrofitFactory.createBasicService())
            )
        ).get(CharacterListViewModelImpl::class.java)

        with(binding) {
            with(recyclerView) {
                characterListAdapter = CharacterListAdapter()
                adapter = characterListAdapter
                layoutManager = LinearLayoutManager(context)
                characterListAdapter.characterOnclickListener = { marvelCharacter ->
                }
            }

            viewModel.characterList.observe(
                viewLifecycleOwner,
                Observer { uiState ->
                    when (uiState) {
                        is CharacterUIState.Success<*> ->
                            characterListAdapter.characterList =
                                uiState.result as List<MarvelCharacter>
                        // TODO Show Error
                    }
                }
            )
        }

        return binding.root
    }
}
