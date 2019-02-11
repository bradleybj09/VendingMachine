package com.example.vendingmachine

import android.app.Application
import androidx.lifecycle.AndroidViewModel


class MainViewModel(application: Application) : AndroidViewModel(application) {

    val products = ArrayList<Product>()

    fun run() {
        setup()

    }

    fun setup() {
        products.add(Drink("A1","Coke","1.00"))
        products.add(Drink("A2", "Pepsi", "1.50"))
    }
}