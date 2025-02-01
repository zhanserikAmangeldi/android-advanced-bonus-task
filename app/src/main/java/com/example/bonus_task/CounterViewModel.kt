package com.example.bonus_task

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private val _count = MutableLiveData<Int>()
    val count: LiveData<Int> get() = _count

    init {
        _count.value = 0
    }

    fun increment() {
        _count.value = (_count.value ?: 0) + 1
    }
}