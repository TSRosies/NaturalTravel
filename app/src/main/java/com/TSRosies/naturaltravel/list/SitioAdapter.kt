package com.TSRosies.naturaltravel.list

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.TSRosies.naturaltravel.R
import com.TSRosies.naturaltravel.model.SitioNaturalItem

import com.squareup.picasso.Picasso

class SitioAdapter(
    private val sitiosList: ArrayList<SitioNaturalItem>
)
    :RecyclerView.Adapter<SitioAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, Viewtype: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sitionatural=sitiosList[position]
        holder.bind(sitionatural)

    }
    override fun getItemCount(): Int = sitiosList.size

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        private val itemImageView:ImageView = itemView.findViewById(R.id.item_image)
        private var nombreTextView:TextView = itemView.findViewById(R.id.nombre)
        private var descripcionTextView:TextView = itemView.findViewById(R.id.descripcion)
        private var puntajeTextView:TextView = itemView.findViewById(R.id.puntaje)



            fun bind(sitionatural: SitioNaturalItem){
                Log.d("nombre",sitionatural.nombre)
                nombreTextView.text= sitionatural.nombre
                descripcionTextView.text = sitionatural.descripcion
                puntajeTextView.text = sitionatural.puntaje
                Picasso.get().load(sitionatural.urlPicture).into(itemImageView)
        }
    }
}