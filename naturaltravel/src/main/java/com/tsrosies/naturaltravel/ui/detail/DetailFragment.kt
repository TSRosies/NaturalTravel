package com.tsrosies.naturaltravel.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.tsrosies.naturaltravel.databinding.FragmentDetailBinding
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem
import com.tsrosies.naturaltravel.R
import com.tsrosies.naturaltravel.ui.main.MainActivity

class DetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDetailBinding
    private val detailViewModel: DetailViewModel by viewModels()
    val list = mutableListOf<CarouselItem>()
    private val args: DetailFragmentArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity?)?.showIcon()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)

        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sitionatural = args.sitionatural
        with(detailBinding) {
            nombreTextView.text = sitionatural.nombre
            descripcion2TextView.text = sitionatural.descripcion2
            ubicacionTextView.text = sitionatural.ubicacion
            temperaturaTextView.text = sitionatural.temperatura
            actividadesTextView.text = sitionatural.actividades


            val carousel: ImageCarousel = view.findViewById(R.id.imagen_carousel)
            list.add(CarouselItem(imageUrl = sitionatural.urlImagen1))
            list.add(CarouselItem(imageUrl = sitionatural.urlImagen2))
            carousel.addData(list)

            mapButton.setOnClickListener {
                findNavController().navigate(DetailFragmentDirections.actionNavigationDetailToMapsFragment(sitionatural))
            }
        }
    }
}
