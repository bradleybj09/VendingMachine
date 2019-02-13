package com.example.vendingmachine

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData




class MainViewModel(application: Application) : AndroidViewModel(application) {

    var products: List<Product> = ArrayList()
    var balance = 0.0
    var balanceString = MutableLiveData<String>()

    init {
        val model = Model()
        products = model.makeAndAddProduct(Util.setupArray)
        updateBalance()
    }

    fun addFunds(addend: Double) {
        balance += addend
        updateBalance()
    }

    fun purchaseProduct(index: Int) {
        if (products[index].count.value == 0) {
            //SOLD OUT
            return
        }
        if(products[index].price.toDouble() > balance) {
            //CANNOT AFFORD
            return
        }
        products[index].decrement()
        balance -= products[index].price.toDouble()
        updateBalance()
        _makeNoise.value = Event(products[index].noise)
    }

    private fun updateBalance() {
        balanceString.value = "$%.2f".format(balance)
    }

    fun endTransaction() {
        _showChange.value = Event(makeChange())
        balance = 0.0
        updateBalance()
    }

    private fun makeChange() : String {
        val quarters = (balance * 100).toInt() / 25
        val dimes = (balance * 100).toInt() % 25 / 10
        val nickels = (balance * 100).toInt() % 25 % 10 / 5
        return "Change - Quarters: $quarters - Dimes: $dimes - Nickels: $nickels"
    }

    //use private event to fire toasts from input

    //change
    private val _showChange = MutableLiveData<Event<String>>()
    val showChange : LiveData<Event<String>>
        get() = _showChange

    //noise
    private val _makeNoise = MutableLiveData<Event<String>>()
    val makeNoise : LiveData<Event<String>>
        get() = _makeNoise
}