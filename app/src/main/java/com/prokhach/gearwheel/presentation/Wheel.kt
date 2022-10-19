package com.prokhach.gearwheel.presentation

data class Wheel(
    val module: Double = 0.0,
    val z: Int = 0,
    val degreeOfAccuracy: Int = 0,
    val typeOfConjugation: String = "",
    val biasFactor: Double = 0.0,
    val tiltAngle: Int = 0,
    val rollerDiameter: Double = 0.0
)