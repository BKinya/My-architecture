package com.beatrice.myarchitecture

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    var modelLiveData = MutableLiveData(MyModel(count = 0))
        private set

    fun updateCount() {
       modelLiveData.apply {
          val count = this.value?.count
           count?.let {
               postValue(MyModel(it.plus(1)))
           }
       }
    }
}