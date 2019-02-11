package com.example.vendingmachine

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR


abstract class Product(_location: String, _name: String, _price: String, _noise: String, var _count: Int = 5) : BaseObservable() {

    companion object {
        val soldOutString = "SOLD OUT"
    }

    @get:Bindable
    var name = _name
        set(value) {
            field = value
            notifyPropertyChanged(BR.product)
        }

    @get:Bindable
    var location = _location
        set(value) {
            field = value
            notifyPropertyChanged(BR.product)
        }

    @get:Bindable
    var price = _price
        set(value) {
            field = value
            notifyPropertyChanged(BR.product)
        }

    @get:Bindable
    var noise = _noise
        set(value) {
            field = value
            notifyPropertyChanged(BR.product)
        }

    @get:Bindable
    var count = _count
        set(value) {
            field = value
            notifyPropertyChanged(BR.product)
        }

}