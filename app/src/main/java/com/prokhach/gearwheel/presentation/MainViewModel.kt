package com.prokhach.gearwheel.presentation

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {




    private companion object {

        const val HEAD_HEIGHT_FACTOR = 0.25
        const val LEVELING_BIAS_FACTOR = 0

        fun angleToRad(angle: Int): Double = angle * Math.PI / 180.0
    }
}
