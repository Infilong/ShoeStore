package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {

//    private val _shoe = MutableLiveData<Shoe>()
//    val shoe: LiveData<Shoe>
//        get() = _shoe

    val shoe = Shoe("", "", "", "")

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    init {
        _shoeList.value = originShoeList()
    }

    fun addShoeToList(newShoe: Shoe) {
        _shoeList.value?.add(newShoe)
    }

    private fun originShoeList(): MutableList<Shoe> {
        return (mutableListOf(
            Shoe("Air Speed", "Nike", "44", "Nike Latest Product"),
            Shoe("Land Fast", "Adidas", "40", "Adidas Latest Product")))
    }
}
