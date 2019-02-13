package com.example.vendingmachine

import android.app.Application
import androidx.lifecycle.AndroidViewModel
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
    }

    private fun updateBalance() {
        balanceString.value = "$%.2f".format(balance)
    }

    fun endTransaction() {
        makeChange()
        balance = 0.0
        updateBalance()
    }

    private fun makeChange() : Array<Int> {
        val quarters = (balance * 100).toInt() % 25
        val dimes = (balance * 100).toInt() / 25 % 10
        val nickels = (balance * 100).toInt() / 25 / 10 % 5
        return arrayOf(quarters, dimes, nickels)
    }
}