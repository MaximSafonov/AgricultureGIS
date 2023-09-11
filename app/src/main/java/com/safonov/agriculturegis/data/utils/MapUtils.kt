package com.safonov.agriculturegis.data.utils

import com.yandex.mapkit.geometry.Point
import kotlin.math.sin

object MapUtils {
    fun polygonArea(coords: List<Point>): Double {
        var area = 0.0
        if (coords.size > 2) {
            for (i in coords.indices - 1) {
                val pointOne = coords[i]
                val pointTwo = coords[i + 1]
                area += rad(pointTwo.longitude - pointOne.longitude) * (2 + sin(rad(pointOne.latitude)) + sin(rad(pointTwo.latitude)))
            }
            area = area * RADIUS * RADIUS / 2
        }
        return area
    }

    private fun rad(ring: Double): Double = (ring * Math.PI / 180)

    fun ringArea(coords: List<Point>): Int {
        var p1: Point
        var p2: Point
        var p3: Point
        var lowerIndex: Int
        var middleIndex: Int
        var upperIndex: Int
        var area = 0;
        var coordsLength = coords.size;
//        var longitude = ymaps.meta.coordinatesOrder == 'latlong' ? 1 : 0;
//        var latitude = ymaps.meta.coordinatesOrder == 'latlong' ? 0 : 1;

        if (coordsLength > 2) {
            for (i in 0..coordsLength) {
                // i = N-2
                if (i == coordsLength - 2) {
                    lowerIndex = coordsLength - 2;
                    middleIndex = coordsLength - 1;
                    upperIndex = 0;
                } else if (i == coordsLength - 1) {
                    // i = N-1
                    lowerIndex = coordsLength - 1;
                    middleIndex = 0;
                    upperIndex = 1;
                } else {
                    // i = 0 to N-3
                    lowerIndex = i;
                    middleIndex = i + 1;
                    upperIndex = i + 2;
                }
                p1 = coords[lowerIndex];
                p2 = coords[middleIndex];
                p3 = coords[upperIndex];
                area += (rad(p3.latitude) - rad(p1.longitude)).toInt() * sin(rad(p2.latitude)).toInt();
            }

            area = area * RADIUS * RADIUS / 2;
        }

        return area;
    }

    /**
     * Earth equatorial radius
     */
    private const val RADIUS = 6378137

}