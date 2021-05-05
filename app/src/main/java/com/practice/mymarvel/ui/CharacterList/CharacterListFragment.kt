package com.practice.mymarvel.ui.characterlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.practice.mymarvel.R
import com.practice.mymarvel.databinding.FragmentCharacterListBinding

class CharacterListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentCharacterListBinding>(inflater, R.layout.fragment_character_list, container, false)

        return binding.root
    }
}
