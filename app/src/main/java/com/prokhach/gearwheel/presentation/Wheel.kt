package com.prokhach.gearwheel.presentation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Wheel(
    val module: Double,
    val z: Int,
    val degreeOfAccuracy: Int,
    val typeOfConjugation: String,
    val biasFactor: Double,
    val tiltAngle: Int
): Parcelable