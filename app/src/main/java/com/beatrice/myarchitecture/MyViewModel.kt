package com.beatrice.myarchitecture

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beatrice.myarchitecture.data.MyModel
import kotlinx.coroutines.launch

class MyViewModel(
    private val repository: MyRepository
) : ViewModel() {
    private val modelLiveData = MutableLiveData(MyModel(id = 1, count = 0))
    val model: LiveData<MyModel> = modelLiveData

    fun updateCount() {
        modelLiveData.apply {
            val updatedCount = (value?.count)?.plus(1)
            updatedCount?.let {
                value = MyModel(count = it, id = 1)

            }
        }
    }

    fun updateCountAndSave() {
        viewModelScope.launch {
            modelLiveData.apply {
                val model = this.value
                model?.let {
                    it.count = it.count + 1
                    postValue(it)
                    repository.saveCount(it)
                }
            }
        }
    }

    fun getCountModel() {
        viewModelScope.launch {
            val countModel = repository.getCount() ?: MyModel(count = 0, id = 1)
            modelLiveData.postValue(countModel)
        }
    }
}