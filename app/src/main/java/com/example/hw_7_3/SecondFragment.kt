package com.example.hw_7_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.hw_7_3.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val result:Character = arguments?.getSerializable("kal") as Character

        binding.apply {
            tvCharactersName.text = result.name
            tvCharacterStatus.text = result.status
            imgSingleCharacter.setImageResource(result.image)
        }
    }
    private fun onItemClick(character:Character){
        val bundle = Bundle()
        bundle.putSerializable("kal",character)
        findNavController().navigate(R.id.secondFragment, bundle)
    }
}