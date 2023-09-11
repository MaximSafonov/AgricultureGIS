package com.safonov.agriculturegis.data.utils

import com.safonov.agriculturegis.data.models.Season
import kotlin.math.exp
import kotlin.math.ln
import kotlin.random.Random

class MeteoData(
    val atmPressure: Int, //P
    val maxAirTemperature: Double, // Tmax curr month
    val minAirTemperature: Double, // Tmin curr month
    val middleAirTemperatureCurrMonth: Double, //T
    val middleAirTemperaturePrevMonth: Double, //T(t-1)
    val windSpeed: Double, // U
    val pureRadiation: Double, //Rn
) {
    /**
     * Фактическое давление пара (Ea)
     */
    fun actualSteamPressure(): Double =
        0.611 * exp((17.27 * minAirTemperature) / (minAirTemperature + 237.3))

    /**
     * Давление пара (eo)
     */
    fun steamPressureActual(): Double = steamPressure(middleAirTemperatureCurrMonth)

    /**
     * Давление насыщенного пара (Es)
     */
    fun saturatedSteamPressure(): Double =
        (steamPressure(minAirTemperature) + steamPressure(maxAirTemperature)) / 2

    /**
     * Скорость ветра на высоте 2м (u2)
     */
    fun windSpeedAtTwoMeters(): Double = (4.87 / (ln(67.8 * 10 - 5.42))) * windSpeed

    /**
     * Наклон кривой давления пара (Svpk) (delta)
     */
    fun steamPressureCurveSlope(): Double =
        (2503 * exp((17.27 * middleAirTemperatureCurrMonth) / (middleAirTemperatureCurrMonth + 237.3))) / ((middleAirTemperatureCurrMonth + 237.3) * (middleAirTemperatureCurrMonth + 237.3))

    /**
     * Психометрическая постоянная (у)
     */
    fun psychoMetricConstY() = 0.000665 * atmPressure

    /**
     * Плотность теплового потока почвы (G)
     */
    fun soilHeatDensity() =
        2.1 * ((middleAirTemperatureCurrMonth + middleAirTemperaturePrevMonth) / (steamPressureCurveSlope() * 48)) * (steamPressureCurveSlope() * 0.12)

    /**
     * Эвапотранспорация (ETo)
     */
    fun evapoTransporation() =
        (0.408 * steamPressureCurveSlope() * (pureRadiation - soilHeatDensity())) + (psychoMetricConstY() * (900 / (middleAirTemperatureCurrMonth + 273)) * windSpeedAtTwoMeters() * (saturatedSteamPressure() - actualSteamPressure())) / (steamPressureCurveSlope() + (psychoMetricConstY() * (1 + 0.34 * windSpeedAtTwoMeters())))

    companion object {
        fun steamPressure(targetAirTemp: Double): Double =
            0.6108 * exp((17.27 * targetAirTemp) / (targetAirTemp + 237.3))

        fun mock(season: Season): MeteoData =
            MeteoData(
                atmPressure = 758,
                maxAirTemperature = provideMaxAirTempperature(season),
                minAirTemperature = provideMaxAirTempperature(season),
                middleAirTemperatureCurrMonth = provideMaxAirTempperature(season), //T
                middleAirTemperaturePrevMonth = provideMaxAirTempperature(season), //T(t-1)
                windSpeed = 3.5, // U
                pureRadiation = 3.73, //Rn
            )

        private fun provideMaxAirTempperature(season: Season): Double = when (season) {
            Season.Autumn -> Random.nextDouble(
                from = season.temperature.first.toDouble(),
                until = season.temperature.last.toDouble()
            )

            Season.Summer -> Random.nextDouble(
                from = season.temperature.first.toDouble(),
                until = season.temperature.last.toDouble()
            )

            Season.Winter -> Random.nextDouble(
                from = season.temperature.first.toDouble(),
                until = season.temperature.last.toDouble()
            )

            Season.Spring -> Random.nextDouble(
                from = season.temperature.first.toDouble(),
                until = season.temperature.last.toDouble()
            )
        }
    }

}


