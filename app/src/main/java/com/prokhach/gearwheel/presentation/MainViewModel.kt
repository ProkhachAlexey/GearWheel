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
    ) : Parcelable {

        private fun pitchDiameter(module: Double, z: Int, tiltAngle: Int): Double {
            val angle = angleToRad(tiltAngle)
            return module * z / Math.cos(angle)
        }



    }

    private companion object {

        const val HEAD_HEIGHT_FACTOR = 0.25
        const val LEVELING_BIAS_FACTOR = 0

        fun angleToRad(angle: Int): Double = angle * Math.PI / 180.0
    }
}
