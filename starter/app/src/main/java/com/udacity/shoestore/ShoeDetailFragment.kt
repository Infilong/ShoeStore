package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)

        binding.cancel.setOnClickListener {
            addShoe()
            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }

        binding.save.setOnClickListener {

            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())

        }
        return binding.root
    }

    private fun addShoe(): Shoe {
        val shoeName = binding.shoeNameInput.text.toString()

        val companyName = binding.companyInput.text.toString()
        val description = binding.shoeDesciptionInput.text.toString()

        try {
            val i = binding.shoeSizeInput
        } catch (e: NumberFormatException) {
            null
        }

        val shoeSize = binding.shoeSizeInput.text.toString().toInt()

        return Shoe(shoeName, shoeSize, companyName, description)
    }

}