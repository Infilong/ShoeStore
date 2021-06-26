package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {


    private lateinit var shoeList: MutableList<Shoe>
    private val _shoe = MutableLiveData<Shoe>()
    val shoe: LiveData<Shoe>
        get() = _shoe

    init {
        shoeListInit()
    }

    private fun shoeListInit() {
        shoeList = mutableListOf<Shoe>(
            Shoe
                ("Air Speed", 44, "Nike", "Nike Latest Product"),
            Shoe
                ("Land Fast", 40, "Adidas", "Adidas Latest Product")
        )
    }
}