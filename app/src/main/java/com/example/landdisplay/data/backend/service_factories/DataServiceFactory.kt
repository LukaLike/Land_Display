/*
 * Created by Lukas (LukaLike) on Fri, Jun 25, '21.
 * Copyright (c) 2021. All rights reserved.
 */

package com.example.landdisplay.data.backend.service_factories

import com.example.landdisplay.data.backend.services.DataService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataServiceFactory {

    private const val API_BASE_URL = "https://releases-f89f5.firebaseio.com/.json/"

    fun create(): DataService {
        val retrofit = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(DataService::class.java)
    }

}