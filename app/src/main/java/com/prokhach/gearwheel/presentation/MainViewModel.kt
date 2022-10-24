package com.prokhach.gearwheel.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel() : ViewModel() {

    private val _wheel = MutableLiveData<Wheel>()
    val wheel: LiveData<Wheel>
        get() = _wheel

    fun saveWheel(wheel: Wheel) {
        _wheel.value = wheel
    }

    private fun loadWheel(): Wheel {
        return _wheel.value ?: throw RuntimeException("Object Wheel is not found")
    }

    private val rollerDiameter: Double = when(loadWheel().module) {
        0.1 -> 0.173
        0.2 -> 0.346
        0.3 -> 0.577
        0.4 -> 0.722
        0.5 -> 0.866
        0.6 -> 0.988
        0.7 -> 1.155
        0.8 -> 1.443
        0.9 -> 1.443
        1.0 -> 1.732
        else -> 0.0
    }


    private companion object {

        const val HEAD_HEIGHT_FACTOR = 0.25
        const val LEVELING_BIAS_FACTOR = 0

        fun angleToRad(angle: Int): Double = angle * Math.PI / 180.0
    }
}
