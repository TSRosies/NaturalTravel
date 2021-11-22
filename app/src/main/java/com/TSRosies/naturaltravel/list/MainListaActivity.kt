package com.TSRosies.naturaltravel.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.TSRosies.naturaltravel.R
import com.TSRosies.naturaltravel.detalle.DetalleActivity
import com.TSRosies.naturaltravel.model.SitioNatural
import com.TSRosies.naturaltravel.model.SitioNaturalItem
import com.google.gson.Gson


class MainListaActivity : AppCompatActivity() {

    private lateinit var listSitios: ArrayList<SitioNaturalItem>
    private lateinit var sitiosAdapter: SitioAdapter
    private lateinit var sitioNaturalRecyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_main_lista)

        sitioNaturalRecyclerView =findViewById(R.id.SitioNaturalRecyclerView)

        //listSitios = createMockSitiosNaturales()

        listSitios = loadMockSitiosNaturalesFromJson()
        sitiosAdapter = SitioAdapter(listSitios, onItemClicked = {onSitionaturalClicked(it)})

        sitioNaturalRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = sitiosAdapter
            setHasFixedSize(false)
        }
    }

    private fun onSitionaturalClicked(sitionatural: SitioNaturalItem) {

        Log.d ("nombre", sitionatural.nombre)
        val intent = Intent(this, DetalleActivity::class.java)
        intent.putExtra("sitionatural",sitionatural)
        startActivity(intent)
    }

    private fun loadMockSitiosNaturalesFromJson(): ArrayList<SitioNaturalItem>{
        val sitioNaturalString:String = applicationContext.assets.open("sitionatural.json").bufferedReader().use{it.readText()}
        val gson = Gson()
        val data = gson.fromJson(sitioNaturalString, SitioNatural::class.java)
        return data
    }


    /*private fun createMockSitiosNaturales(): ArrayList<SitioNatural> {
         Crear Sitio uno a uno
        var lista: ArrayList<SitioNatural> = arrayListOf()

         var sitionatural = Sitionatural(
             nombre = "Parque Ecológico Pionono",
             descripcion= "El Parque Natural Ecológico Pionono, es una reserva natural, conocido como el cerro de las águilas, comprende desde 2.800 metros hasta 3.250 metros. ",
             puntuacion = "5"


         )
         lista.add(sitionatural)
         return lista*/

        /*return arrayListOf(
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
        )*/
    }