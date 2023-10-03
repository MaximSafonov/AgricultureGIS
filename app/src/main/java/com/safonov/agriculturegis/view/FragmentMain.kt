package com.safonov.agriculturegis.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.widget.AppCompatSpinner
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.safonov.agriculturegis.R
import com.safonov.agriculturegis.data.db.PrePopulateData
import com.safonov.agriculturegis.databinding.FragmentMainBinding

class FragmentMain : Fragment(R.layout.fragment_main) {
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.createFieldButton.setOnClickListener {
            val args = FieldActivityArgs(
                fieldId = PrePopulateData.fieldList.first {
                    it.name == binding.fieldList.selectedItem.toString()
                }.fieldId,
                culture = binding.agriculture.selectedItem.toString(),
                sensor = binding.sensorList.selectedItem.toString(),
                season = binding.situationList.selectedItem.toString(),
            )

            findNavController().navigate(R.id.action_main_to_field, args.toBundle())
        }

        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            PrePopulateData.fieldList.map { it.name })
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.fieldList.adapter = adapter

        loadSpinner(binding.sensorList, R.array.sensor_types)
        loadSpinner(binding.situationList, R.array.situation_types)
        loadSpinner(binding.agriculture, R.array.culture_types)
    }

    private fun loadSpinner(
        spinner: AppCompatSpinner,
        res: Int
    ) {
        ArrayAdapter.createFromResource(
            requireContext(),
            res,
            android.R.layout.simple_spinner_item
        ).also { adapter ->

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

}