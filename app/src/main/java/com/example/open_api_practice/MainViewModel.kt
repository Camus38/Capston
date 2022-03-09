package com.example.open_api_practice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val countLiveData : MutableLiveData<Int> = MutableLiveData<Int>()

    init {
        countLiveData.value = 0
    }

    fun increaseCount() {
        countLiveData.value = (countLiveData.value ?: 0) +1
    }
}