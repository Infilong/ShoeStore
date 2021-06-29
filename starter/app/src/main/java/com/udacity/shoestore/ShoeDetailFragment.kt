package com.udacity.shoestore

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel

class ShoeDetailFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailBinding
    private lateinit var viewModel: ShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)

        binding.cancel.setOnClickListener {
            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }

        binding.save.setOnClickListener {
            clickSave()
        }
        return binding.root
    }

    private fun clickSave() {
        if (TextUtils.isEmpty(binding.shoeNameInput.text.toString()) ||
            TextUtils.isEmpty(binding.shoeCompanyInput.text.toString()) ||
            TextUtils.isEmpty(binding.shoeSizeInput.text.toString()) ||
            TextUtils.isEmpty(binding.shoeDesciptionInput.text.toString())
        ) {
            Toast.makeText(requireContext(), "Please Fill All Columns", Toast.LENGTH_SHORT).show()
        } else {
            val newShoe = (Shoe(
                binding.shoeNameInput.text.toString(),
                binding.shoeCompanyInput.text.toString(),
                binding.shoeSizeInput.text.toString().toInt(),
                binding.shoeDesciptionInput.text.toString()
            ))
            viewModel.addShoeToList(newShoe)



        }
        findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
    }


}