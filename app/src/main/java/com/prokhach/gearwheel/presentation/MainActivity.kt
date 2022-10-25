package com.prokhach.gearwheel.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.prokhach.gearwheel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var wheel: Wheel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        savedInstanceState?.getParcelable(KEY) ?: Wheel(
            0.0,
            0,
            0,
            "",
            0.0,
            0
        ).also {
            updateUi()
        }

        binding.calculateButton.setOnClickListener {
            viewModel.saveWheel(generateNewWheel())
            binding.etRollerDiameter.setText(viewModel.loadRollerDiameter().toString())
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY, wheel)
    }

    private fun generateNewWheel(): Wheel {
        return Wheel(
            binding.etModule.text.toString().toDouble(),
            binding.etWheel.text.toString().toInt(),
            binding.etDegreeOfAccuracy.text.toString().toInt(),
            binding.etTypeOfConjugation.text.toString(),
            binding.etBiasFactor.text.toString().toDouble(),
            binding.etTiltAngle.text.toString().toInt()
        )
    }

    private fun updateUi() {
        binding.etModule.setText(wheel.module.toString())
        binding.etWheel.setText(wheel.z.toString())
        binding.etDegreeOfAccuracy.setText(wheel.degreeOfAccuracy.toString())
        binding.etTypeOfConjugation.setText(wheel.typeOfConjugation)
        binding.etBiasFactor.setText(wheel.biasFactor.toString())
        binding.etTiltAngle.setText(wheel.tiltAngle.toString())
    }

    private companion object {

        const val KEY = "key"
    }
}
