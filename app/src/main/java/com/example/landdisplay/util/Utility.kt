/*
 * Created by Lukas (LukaLike) on Fri, Jun 25, '21.
 * Copyright (c) 2021. All rights reserved.
 */

package com.example.landdisplay.util

import com.google.android.gms.maps.model.BitmapDescriptorFactory
import java.lang.IllegalArgumentException

fun getMarkerColor(accuracy: Double): Float {
    return if (accuracy < 0) {
        throw IllegalArgumentException()
    } else if (accuracy in 0.0..1.5) {
        BitmapDescriptorFactory.HUE_GREEN
    } else if (accuracy > 1.5 && accuracy <= 2.0) {
        BitmapDescriptorFactory.HUE_YELLOW
    } else {
        BitmapDescriptorFactory.HUE_ORANGE
    }
}