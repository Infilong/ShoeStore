package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {
    private val _shoes = MutableLiveData<Shoe>()
    val shoes: LiveData<Shoe>
        get() = _shoes

    private val shoeList = mutableListOf<Shoe>(
        Shoe
            ("Air Speed", 44, "Nike", "Nike Latest Product"),
        Shoe
            ("Land Fast", 40, "Adidas", "Adidas Latest Product")
    )

}