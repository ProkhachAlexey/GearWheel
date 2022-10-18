package com.prokhach.gearwheel.presentation

import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.android.parcel.Parcelize

class MainViewModel : ViewModel() {

    private val wheelLiveData = MutableLiveData<Wheel>()
    val wheel: LiveData<Wheel>
        get() = wheelLiveData

    fun initWheel(wheel: Wheel) {
        wheelLiveData.value = wheel
    }

    @Parcelize
    data class Wheel(
        val module: Double,
        val z: Int,
        val degreeOfAccuracy: Int,
        val typeOfConjugation: Char,
        val biasFactor: Double,
        val tiltAngle: Int,
        val rollerDiameter: Double
    ) : Parcelable
}
