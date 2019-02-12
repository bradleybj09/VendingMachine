package com.example.vendingmachine

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData


abstract class Product(val location: String, val name: String, val price: String, val noise: String) : BaseObservable() {

    var count = MutableLiveData<Int>()
    init {
        count.value = 5
    }



    fun decrement() {
        count.value = count.value?.dec()
    }

}