package com.example.vendingmachine

abstract class Product(val location: String, val name: String, val price: String, val noise: String) {

    val count = 5;

    fun makeNoise() : String {
        return noise
    }
}