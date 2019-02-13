package com.example.vendingmachine

class Util private constructor(){

    companion object {
        val setupArray = arrayOf(
            "A1|Potato Crisps|3.05|Chip",
            "A2|Stackers|1.45|Chip",
            "A3|Grain Waves|2.75|Chip",
            "A4|Cloud Popcorn|3.65|Chip",
            "B1|Moonpie|1.80|Candy",
            "B2|Cowtales|1.50|Candy",
            "B3|Wonka Bar|1.50|Candy",
            "B4|Crunchie|1.75|Candy",
            "C1|Cola|1.25|Drink",
            "C2|Dr. Salt|1.50|Drink",
            "C3|Mountain Melter|1.50|Drink",
            "C4|Heavy|1.50|Drink",
            "D1|U-Chews|0.85|Gum",
            "D2|Little League Chew|0.95|Gum",
            "D3|Chiclets|0.75|Gum",
            "D4|Triplemint|0.75|Gum")

        const val TYPE_CHIP_STRING = "Chip"
        const val TYPE_CANDY_STRING = "Candy"
        const val TYPE_GUM_STRING = "Gum"
        const val TYPE_DRINK_STRING = "Drink"


        fun convertStringToCents(s: String): Int {
            return Integer.parseInt(s.replace(".", ""))
        }

        fun convertCentsToString(i: Int): String {
            val dollarString = (i / 100).toString()
            var centsString = (i % 100).toString()
            if (centsString == "0") {
                centsString = "00"
            } else if (centsString.length == 1) {
                centsString = "0$centsString"
            }
            return "$$dollarString.$centsString"
        }
    }


}