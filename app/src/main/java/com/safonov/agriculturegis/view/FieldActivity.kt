package com.safonov.agriculturegis.view

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.navArgs
import com.safonov.agriculturegis.R
import com.safonov.agriculturegis.data.models.Season
import com.safonov.agriculturegis.databinding.ActivityFieldBinding
import com.safonov.agriculturegis.viewmodel.FieldViewModel
import com.safonov.agriculturegis.viewmodel.baseViewModels
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Circle
import com.yandex.mapkit.geometry.LinearRing
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.geometry.Polygon
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.map.MapObjectCollection
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.image.ImageProvider

class FieldActivity: AppCompatActivity() {
    private lateinit var binding: ActivityFieldBinding
    private lateinit var mapView: MapView
    private lateinit var mapObjects: MapObjectCollection
    private val viewModel by baseViewModels { FieldViewModel() }
    private val args: FieldActivityArgs by navArgs()

    private val palaceSquare = Point(59.945933, 30.320045)
    private val rosinkaCenter = Point(60.257954, 29.836189)

    private val azovPoint = Point(46.971780, 39.177087)

    private val azovPointSensor1 = Point(46.994470, 39.146218)
    private val azovPointSensor2 = Point(46.985082, 39.206813)
    private val azovPointSensor3 = Point(46.943991, 39.209100)
    private val azovPointSensor4 = Point(46.945948, 39.147361)

    private val azovFieldPoints = listOf(
        Point(47.006073, 39.115005),
        Point(47.000397, 39.234938),
        Point(46.924486, 39.238710),
        Point(46.926036, 39.111988),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFieldBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mapView = binding.mapview
        provideChoseSeason(args.season)

        binding.season.text = args.season
        binding.culture.text = args.culture
        binding.sensor.text = args.sensor

        mapObjects = mapView.map.mapObjects.addCollection()
        mapObjects.addPolygon(
            Polygon(LinearRing(azovFieldPoints), ArrayList())
        ).apply {
            fillColor = R.color.field
            strokeColor = R.color.field_border
            strokeWidth = 10F
        }

        placeSensors()

        mapView.map.move(
            CameraPosition(azovPoint, 11.0f, 0.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 2f),
            null
        )

        binding.makeButton.setOnClickListener {
            showResults()
        }
    }

    private fun placeSensors() {
        mapObjects.addPlacemark(azovPointSensor1, ImageProvider.fromResource(this, R.drawable.ic_dollar_pin) )
        mapObjects.addPlacemark(azovPointSensor2, ImageProvider.fromResource(this, R.drawable.ic_dollar_pin) )
        mapObjects.addPlacemark(azovPointSensor3, ImageProvider.fromResource(this, R.drawable.ic_dollar_pin) )
        mapObjects.addPlacemark(azovPointSensor4, ImageProvider.fromResource(this, R.drawable.ic_dollar_pin) )

        mapObjects.addCircle(Circle(azovPointSensor1, 3000f), Color.GREEN, 2f, Color.DKGRAY).apply { zIndex = 100.0f }
        mapObjects.addCircle(Circle(azovPointSensor2, 3000f), Color.GREEN, 2f, Color.TRANSPARENT).apply { zIndex = 100.0f }
        mapObjects.addCircle(Circle(azovPointSensor3, 3000f), Color.GREEN, 2f, Color.TRANSPARENT).apply { zIndex = 100.0f }
        mapObjects.addCircle(Circle(azovPointSensor4, 3000f), Color.GREEN, 2f, Color.TRANSPARENT).apply { zIndex = 100.0f }
    }

    private fun provideChoseSeason(season: String) {
        viewModel.currentSeason.value =
            when (season) {
                "Лето (от10 до 30 С)" -> Season.Summer
                "Весна (от -5 до 10 С)"-> Season.Spring
                "Зима (от -20 до 10 С)" -> Season.Winter
                "Осень (от -10 до 20 С)" -> Season.Autumn
                else -> Season.Summer
            }
    }

    override fun onStop() {
        mapView.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        mapView.onStart()
    }

    private fun showResults() {
        FragmentRecomendations.show(supportFragmentManager)
    }



}