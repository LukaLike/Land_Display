/*
 * Created by Lukas (LukaLike) on Fri, Jun 25, '21.
 * Copyright (c) 2021. All rights reserved.
 */

package com.example.landdisplay.ui.map

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.landdisplay.data.Event
import com.example.landdisplay.data.backend.service_factories.DataServiceFactory
import com.example.landdisplay.data.models.Data
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MapViewModel : ViewModel() {

    /**
     * Data associated
     */
    val dataMutable = MutableLiveData<Event<Data>>()

    init {
        getData()
    }

    private fun getData() {
        val call = DataServiceFactory.create().getData()
        call.enqueue(object: Callback<Data> {
            override fun onResponse(
                call: Call<Data>,
                response: Response<Data>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()
                    if (data != null) {
                        dataMutable.value = Event(data)
                    }
                } else {
                    Log.e(TAG, response.toString())
                }
            }

            override fun onFailure(call: Call<Data>, t: Throwable) {
                Log.e(TAG, t.message.toString())
            }
        })
    }

    companion object {
        private const val TAG = "MapViewModel"
    }

}