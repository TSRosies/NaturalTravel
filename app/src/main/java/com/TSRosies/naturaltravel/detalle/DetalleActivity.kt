package com.TSRosies.naturaltravel.detalle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.TSRosies.naturaltravel.R
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class DetalleActivity : AppCompatActivity() {
    val list = mutableListOf<CarouselItem>()
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)
        val carousel: ImageCarousel = findViewById(R.id.carousel)
        list.add(CarouselItem(imageDrawable = R.drawable.laguna_de_pedro_palo))
        list.add(CarouselItem(imageDrawable = R.drawable.laguna_de_pedro_palo2))
        carousel.addData(list)
    }
}