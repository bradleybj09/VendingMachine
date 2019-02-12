package com.example.vendingmachine

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData


class MainViewModel(application: Application) : AndroidViewModel(application) {

    val products: ArrayList<Product> = ArrayList()
    var balance = 0.0
    var balanceString = MutableLiveData<String>()

    init {
        products.add(Drink("A1","Coke","1.00"))
        products.add(Drink("A2", "Pepsi", "1.50"))
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
    }

    private fun updateBalance() {
        balanceString.value = "$%.2f".format(balance)
    }
}