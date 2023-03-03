package com.example.hw_7_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hw_7_3.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private lateinit var characterList: ArrayList<Character>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        val adapter = CharacterAdapter(characterList, this::onItemClick)
        binding.recyclerView.adapter = adapter
    }

    private fun loadData() {
        characterList = ArrayList<Character>()
        characterList.apply {
            add(Character("Rick Sanchez", "Alive", R.drawable.ic_first_image))
            add(Character("Morty Smith","Alive", R.drawable.ic_second_image))
            add(Character("Albert Einstein","Dead", R.drawable.ic_third_image))
            add(Character("Jerry Smith","Alive", R.drawable.ic_fourth_image))
        }
    }
    private fun onItemClick(character: Character){
        findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment(character))
    }
}