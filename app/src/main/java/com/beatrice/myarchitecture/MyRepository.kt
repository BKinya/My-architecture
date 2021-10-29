package com.beatrice.myarchitecture

import com.beatrice.myarchitecture.data.MyDao
import com.beatrice.myarchitecture.data.MyModel

class MyRepository(
    private val dao: MyDao
) {
    suspend fun saveCount(model: MyModel) {
        dao.saveCount(model)
    }

    suspend fun getCount() = dao.getCount()
}