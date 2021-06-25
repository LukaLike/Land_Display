/*
 * Created by Lukas (LukaLike) on Fri, Jun 25, '21.
 * Copyright (c) 2021. All rights reserved.
 */

package com.example.landdisplay.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.landdisplay.data.Event

class MainViewModel : ViewModel() {

    /**
     * Click events associated
     */
    val openClickEvent = MutableLiveData<Event<Unit>>()

    fun openGoogleMaps() {
        openClickEvent.value = Event(Unit)
    }

}