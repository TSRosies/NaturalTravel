package com.TSRosies.naturaltravel.detalle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.TSRosies.naturaltravel.R
import com.TSRosies.naturaltravel.databinding.ActivityDetalleBinding
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class DetalleActivity : AppCompatActivity() {

    private lateinit var detalleBinding: ActivityDetalleBinding

    val list = mutableListOf<CarouselItem>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        detalleBinding = ActivityDetalleBinding.inflate(layoutInflater)
        /* setContentView(R.layout.activity_detalle) */
        val carousel: ImageCarousel = findViewById(R.id.imagen_carousel)
        list.add(CarouselItem(imageDrawable = R.drawable.laguna_de_pedro_palo))
        list.add(CarouselItem(imageDrawable = R.drawable.laguna_de_pedro_palo2))
        carousel.addData(list)

        val nombre = intent.extras?.getString("nombre")
        detalleBinding.nombreTextView.text =nombre
    }
}