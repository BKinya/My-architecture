package com.beatrice.myarchitecture.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCount(model: MyModel)

    @Query("SELECT * FROM my_model")
    suspend fun getCount(): MyModel?
}