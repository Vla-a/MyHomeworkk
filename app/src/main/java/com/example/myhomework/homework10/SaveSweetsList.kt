package com.example.myhomework.homework10


class SaveSweetsList() {

    fun result(): MutableList<Sweets> {

        var saveSweetsList: MutableList<Sweets> = mutableListOf()

        for (i in 1..300) {
            when (i) {
                in 1..100 -> {
                    saveSweetsList.add(Sweets(MARS, randomNumbers()))

                }
                in 101..200 -> {
                    saveSweetsList.add(Sweets(SNICKERS, randomNumbers()))
                }
                in 201..300 -> {
                    saveSweetsList.add(Sweets(NUTS, randomNumbers()))
                }
            }
        }
        return saveSweetsList
    }

    private fun randomNumbers() = (10000000..99999999).random()

    companion object {
        const val MARS = "MARS"
        const val SNICKERS = "SNICKERS"
        const val NUTS = "NUTS"
    }
}



