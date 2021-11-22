package com.TSRosies.naturaltravel.detalle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.TSRosies.naturaltravel.R
import com.TSRosies.naturaltravel.databinding.ActivityDetalleBinding
import com.TSRosies.naturaltravel.model.SitioNaturalItem
import com.squareup.picasso.Picasso
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem
import org.imaginativeworld.whynotimagecarousel.ImageCarousel.Companion as ImageCarousel1

class DetalleActivity : AppCompatActivity() {

    private lateinit var detalleBinding: ActivityDetalleBinding

    val list = mutableListOf<CarouselItem>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        detalleBinding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(detalleBinding.root)
        /* setContentView(R.layout.activity_detalle) */

        val carousel: ImageCarousel = findViewById(R.id.imagen_carousel)
        list.add(CarouselItem(imageDrawable = R.drawable.laguna_de_pedro_palo))
        list.add(CarouselItem(imageDrawable = R.drawable.laguna_de_pedro_palo2 ))
        carousel.addData(list)

        val sitionatural: SitioNaturalItem = intent.extras?.getSerializable("SitioNaturalItem ") as SitioNaturalItem

        with(detalleBinding) {
            nombreTextView.text = sitionatural.nombre
            descripcion2TextView.text = sitionatural.descripcion2
            ubicacionTextView.text = sitionatural.ubicacion
            temperaturaTextView.text = sitionatural.temperatura
            actividadesTextView.text = sitionatural.actividades
         //   Picasso.get().load(sitionatural.urlImagen1).into(carousel)

        }

        }
}