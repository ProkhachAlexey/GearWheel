package com.prokhach.gearwheel.presentation

import android.os.Bundle
import android.util.Log
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

        binding.calculateButton.setOnClickListener {
            wheel = Wheel(
                binding.etModule.text.toString().toDouble(),
                binding.etWheel.text.toString().toInt(),
                binding.etDegreeOfAccuracy.text.toString().toInt(),
                binding.etTypeOfConjugation.text.toString(),
                binding.etBiasFactor.text.toString().toDouble(),
                binding.etTiltAngle.text.toString().toInt(),
                binding.etRollerDiameter.text.toString().toDouble()
            )
            viewModel.wheelLD.value
        }

    }
}
