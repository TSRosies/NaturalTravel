package com.tsrosies.naturaltravel.maps

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.tsrosies.naturaltravel.R
import com.tsrosies.naturaltravel.databinding.FragmentMapsBinding
import com.tsrosies.naturaltravel.detail.DetailFragmentArgs

class MapsFragment : Fragment() {
    private lateinit var mapsBinding: FragmentMapsBinding
    private val args: DetailFragmentArgs by navArgs()

    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */

        /**val sydney = LatLng(-34.0, 151.0)
        googleMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))*/

        fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            val sitionatural = args.sitionatural
            with(mapsBinding) {
                val nombre = sitionatural.nombre
                val latitud = sitionatural.latitud
                val longitud = sitionatural.longitud

                val ubicacion = LatLng(latitud, longitud)
                googleMap.addMarker(
                    MarkerOptions()
                        .position(ubicacion)
                        .title("aqui es un sitio natural")
                        .snippet("Cundinamarca")
                )
                googleMap.addMarker(MarkerOptions().position(ubicacion).title("Cundinamarca"))
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacion, 15F))
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}