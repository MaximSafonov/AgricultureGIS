package com.safonov.agriculturegis.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.safonov.agriculturegis.R
import com.safonov.agriculturegis.databinding.FragmentRecommendationsBinding
import com.safonov.agriculturegis.viewmodel.FieldViewModel
import com.safonov.agriculturegis.viewmodel.baseViewModels

class FragmentRecomendations: BottomSheetDialogFragment() {
    private lateinit var binding: FragmentRecommendationsBinding
    private val viewModel by baseViewModels(::requireActivity) { FieldViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(R.style.BottomSheet, theme)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentRecommendationsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            atmPressureValue.text = viewModel.meteoData.value.atmPressure.toString()
            pureRadiationValue.text = viewModel.meteoData.value.pureRadiation.toString()
            evapoValue.text = viewModel.meteoData.value.evapoTransporation().toString()
            recomendations.text = viewModel.recommendations.value

            makeButton.setOnClickListener {
                dismiss()
            }
        }
    }

    companion object {
        fun show(parent: FragmentManager) {
            FragmentRecomendations().show(parent, null)
        }
    }
}