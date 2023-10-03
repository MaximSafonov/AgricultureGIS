package com.safonov.agriculturegis.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.safonov.agriculturegis.data.models.FieldModel
import com.safonov.agriculturegis.data.FieldRepository
import com.safonov.agriculturegis.data.db.entity.FieldDataEntity
import com.safonov.agriculturegis.data.models.Recommendations
import com.safonov.agriculturegis.data.models.Season
import com.safonov.agriculturegis.data.utils.MeteoData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FieldViewModel() : ViewModel() {

    private val _field = MutableStateFlow<FieldModel?>(null)
    val field = _field.asStateFlow()

    val currentSeason = MutableStateFlow(Season.Summer)

    private val _meteoData = MutableStateFlow(MeteoData.mock(currentSeason.value))
    val meteoData = _meteoData.asStateFlow()

    private val _recommendations = MutableStateFlow("")
    val recommendations = _recommendations.asStateFlow()

    private val _fieldArea = MutableStateFlow(0.0)
    val fieldArea = _fieldArea.asStateFlow()

    private val _fields = MutableStateFlow<List<FieldDataEntity>>(emptyList())
    val fields = _fields.asStateFlow()

    fun loadField(cadNumber: String) {
        viewModelScope.launch {
//            kotlin.runCatching {
//                fieldRepository.searchField(cadNumber)
//            }.onSuccess { field ->
//                _field.value = field ?: FieldModel.mock(cadNumber)

//            }
        }
    }

    init {
        provideRecomendations(meteoData.value.evapoTransporation())

        viewModelScope.launch {
//            fieldRepository.allFields.collect {
//                _fields.value = it
//            }
        }
    }

    private fun provideRecomendations(evapo: Double){
        _recommendations.value = when(evapo.toInt()) {
            in Recommendations.FirstCategory().range -> Recommendations.FirstCategory().recommendation
            in Recommendations.SecondCategory().range -> Recommendations.SecondCategory().recommendation
            in Recommendations.ThirdCategory().range -> Recommendations.FirstCategory().recommendation
            in Recommendations.FourthCategory().range -> Recommendations.FirstCategory().recommendation
            else -> Recommendations.Unknown.recommendation
        }
    }
}