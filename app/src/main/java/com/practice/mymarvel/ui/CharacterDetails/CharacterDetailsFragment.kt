package com.practice.mymarvel.ui.characterdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.practice.mymarvel.R
import com.practice.mymarvel.databinding.FragmentCharacterListBinding

class CharacterDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentCharacterListBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_character_details, container, false)

        return binding.root
    }
}
