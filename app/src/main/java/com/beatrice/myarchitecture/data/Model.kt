package com.beatrice.myarchitecture.data

data class Model(
    var count: Int
) {
    fun updateCount(){
        count += 1
    }
}