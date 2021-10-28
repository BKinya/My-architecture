package com.beatrice.myarchitecture

data class MyModel(
    var count: Int
) {
    fun updateCount(){
        count += 1
    }
}