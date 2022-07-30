package com.example.thirdmonthsevenhw

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.thirdmonthsevenhw.databinding.FragmentCharacterBinding

class CharacterFragment : Fragment() {

    private lateinit var binding: FragmentCharacterBinding
    private val data = arrayListOf<Character>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        val adapter = CharacterAdapter(data,this::onClick)
        binding.recyclerview.adapter = adapter

    }

    private fun loadData() {
        data.add(Character("https://www.pngkey.com/png/detail/3-35089_rick-sprite-rick-sanchez.png","Alive","Rick Sanchez"))
        data.add(Character("https://www.nicepng.com/png/detail/68-685847_lawyer-morty-morty-smith.png","Alive","Morty Smith"))
        data.add(Character("https://i.pinimg.com/736x/74/45/22/744522196d39471151f0cba758b0f92b.jpg","Dead","Albert Einstein"))
        data.add(Character("https://www.pngkit.com/png/detail/5-53762_jerry-jerry-smith-rick-and-morty-png.png","Alive","Jerry Smith"))
    }

    private fun onClick(pos:Int){
        val bundle = Bundle()
        bundle.putSerializable("character",data[pos])
        findNavController().navigate(R.id.profileFragment,bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}