package com.beatrice.myarchitecture.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "my_model")
data class MyModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var count: Int
) {
    fun updateCount(){
        count += 1
    }
}