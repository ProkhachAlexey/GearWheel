package com.prokhach.gearwheel.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.prokhach.gearwheel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.saveWheel(
            savedInstanceState?.getParcelable(KEY_WHEEL) ?: viewModel.getEmptyWheel()
        )

        binding.calculateButton.setOnClickListener {
            viewModel.saveWheel(generateNewWheel())
            binding.etRollerDiameter.setText(viewModel.loadRollerDiameter().toString())
        }

//        viewModel.wheel.observe(this, Observer {
//            updateEditText(it)
//        })
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY_WHEEL, viewModel.wheel.value)
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

//    private fun updateEditText(wheel: Wheel) = with(binding) {
//        etModule.setText(wheel.module.toString())
//        etWheel.setText(wheel.z.toString())
//        etDegreeOfAccuracy.setText(wheel.degreeOfAccuracy.toString())
//        etTypeOfConjugation.setText(wheel.typeOfConjugation)
//        etBiasFactor.setText(wheel.biasFactor.toString())
//        etTiltAngle.setText(wheel.tiltAngle.toString())
//    }

    private companion object {

        const val KEY_WHEEL = "KEY_WHEEL"
    }
}
