package com.prokhach.gearwheel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val someVar = MutableLiveData<Int>()
    val someVarLD: LiveData<Int>
        get() = someVar



}
