package com.beatrice.myarchitecture

import android.util.Log
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

   private val countModelLiveData = MutableLiveData<MyModel>()
     val countModel: LiveData<MyModel> = countModelLiveData
    fun updateCount() {
       modelLiveData.apply {
          val count = this.value?.count
           count?.let {
               postValue(MyModel(count= it.plus(1), id = 1,))
           }
       }
    }

    fun updateCountAndSave(){
        viewModelScope.launch {
            countModelLiveData.apply {
                val model = this.value
                model?.let {
                    it.count = it.count + 1
                    postValue(it)
                    repository.saveCount(it)
                }
            }
        }
    }
   fun getCountModel(){
        viewModelScope.launch {
            val countModel = repository.getCount() ?: MyModel(count = 0, id = 1)
            countModelLiveData.postValue(countModel)
        }
   }
}