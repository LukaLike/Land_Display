/*
 * Created by Lukas (LukaLike) on Fri, Jun 25, '21.
 * Copyright (c) 2021. All rights reserved.
 */

package com.example.landdisplay.ui.map

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.landdisplay.MainActivity
import com.example.landdisplay.R
import com.example.landdisplay.data.EventObserver
import com.example.landdisplay.databinding.FragmentMapBinding
import com.example.landdisplay.util.getMarkerColor
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolygonOptions

class MapFragment : Fragment(), OnMapReadyCallback {

    private lateinit var binding: FragmentMapBinding
    private val viewModel: MapViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMapBinding.inflate(inflater, container, false)

        configureToolbar()
        configureMaps()

        binding.lifecycleOwner = this.viewLifecycleOwner
        return binding.root
    }

    @SuppressLint("RestrictedApi")
    private fun configureToolbar() {
        (activity as MainActivity).supportActionBar?.setShowHideAnimationEnabled(false)
        (activity as MainActivity).supportActionBar?.hide()
    }

    private fun configureMaps() {
        val mapFragment = childFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        viewModel.dataMutable.observe(viewLifecycleOwner, EventObserver { data ->
            data.features.forEach { feature ->
                val points = feature.points
                val coordinates = points.map {
                    googleMap.addMarker(
                        MarkerOptions().position(LatLng(it.latitude, it.longitude)).icon(
                            BitmapDescriptorFactory.defaultMarker(getMarkerColor(it.accuracy))
                        )
                    )
                    LatLng(it.latitude, it.longitude)
                }

                val polygon =
                    googleMap.addPolygon(
                        PolygonOptions().addAll(coordinates).fillColor(FILL_COLOR)
                    )
                polygon.strokeColor = STROKE_COLOR
            }

            // Move camera
            val coordinate = data.features[0].points[0]
            val zoom = 10f
            googleMap.moveCamera(
                CameraUpdateFactory.newLatLngZoom(
                    LatLng(coordinate.latitude, coordinate.longitude), zoom
                )
            )
        })
    }

    companion object {
        const val STROKE_COLOR = Color.DKGRAY
        const val FILL_COLOR = Color.RED
    }

}