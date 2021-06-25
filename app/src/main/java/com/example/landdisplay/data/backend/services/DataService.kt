/*
 * Created by Lukas (LukaLike) on Fri, Jun 25, '21.
 * Copyright (c) 2021. All rights reserved.
 */

package com.example.landdisplay.data.backend.services

import com.example.landdisplay.data.models.Data
import retrofit2.Call
import retrofit2.http.GET

interface DataService {

    @GET(".")
    fun getData(): Call<Data>

}