package com.TSRosies.naturaltravel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainListaActivity : AppCompatActivity() {

    private lateinit var listSitios: ArrayList<SitioNatural>
    private lateinit var sitiosAdapter: SitioAdapter
    private lateinit var sitioNaturalRecyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_main_lista)

        sitioNaturalRecyclerView =findViewById(R.id.SitioNaturalRecyclerView)

        listSitios = createMockSitiosNaturales()
        sitiosAdapter = SitioAdapter(listSitios)

        sitioNaturalRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = sitiosAdapter
            setHasFixedSize(false)
        }
    }
    private fun createMockSitiosNaturales(): ArrayList<SitioNatural> {
        /* Crear Sitio uno a uno
        var lista: ArrayList<SitioNatural> = arrayListOf()

         var sitionatural = Sitionatural(
             nombre = "Parque Ecológico Pionono",
             descripcion= "El Parque Natural Ecológico Pionono, es una reserva natural, conocido como el cerro de las águilas, comprende desde 2.800 metros hasta 3.250 metros. ",
             puntuacion = "5"

         )
         lista.add(sitionatural)
         return lista*/

        return arrayListOf(
            SitioNatural(
                nombre = "Parque Ecológico Pionono",
                descripcion= "El Parque Natural Ecológico Pionono, es una reserva natural, conocido como el cerro de las águilas, comprende desde 2.800 metros hasta 3.250 metros. ",
                puntuacion = "5"

            ),
            SitioNatural(
                nombre = "Parque Ecológico Pionono",
                descripcion= "El Parque Natural Ecológico Pionono, es una reserva natural, conocido como el cerro de las águilas, comprende desde 2.800 metros hasta 3.250 metros. ",
                puntuacion ="5"
            ),
            SitioNatural(
                nombre = "Parque Ecológico Pionono",
                descripcion= "El Parque Natural Ecológico Pionono, es una reserva natural, conocido como el cerro de las águilas, comprende desde 2.800 metros hasta 3.250 metros. ",
                puntuacion = "5"
            ),
            SitioNatural(
                nombre = "Parque Ecológico Pionono",
                descripcion= "El Parque Natural Ecológico Pionono, es una reserva natural, conocido como el cerro de las águilas, comprende desde 2.800 metros hasta 3.250 metros. ",
                puntuacion = "5"
            ),
            SitioNatural(
                nombre = "Parque Ecológico Pionono",
                descripcion= "El Parque Natural Ecológico Pionono, es una reserva natural, conocido como el cerro de las águilas, comprende desde 2.800 metros hasta 3.250 metros. ",
                puntuacion = "5"
            )
        )
    }
}