/*
 * Created by Lukas (LukaLike) on Fri, Jun 25, '21.
 * Copyright (c) 2021. All rights reserved.
 */

package com.example.landdisplay.data.models

import com.google.gson.annotations.SerializedName

data class Point(
    @SerializedName("accuracy")
    val accuracy: Double,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double
)