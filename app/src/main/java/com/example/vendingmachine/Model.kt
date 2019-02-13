package com.example.vendingmachine

class Model {

    fun makeAndAddProduct(strings: Array<String>): List<Product> {
        var products = ArrayList<Product>()
        for (string in strings) {
            val array = string.split("|")
            val slotLocation = array[0]
            val name = array[1]
            val priceString = array[2]
            val type = array[3]
            when (type) {
                Util.TYPE_CHIP_STRING -> products.add(Chip(slotLocation, name, priceString))
                Util.TYPE_CANDY_STRING -> products.add(Candy(slotLocation, name, priceString))
                Util.TYPE_DRINK_STRING -> products.add(Drink(slotLocation, name, priceString))
                Util.TYPE_GUM_STRING -> products.add(Gum(slotLocation, name, priceString))
            }
        }
        return products
    }
}