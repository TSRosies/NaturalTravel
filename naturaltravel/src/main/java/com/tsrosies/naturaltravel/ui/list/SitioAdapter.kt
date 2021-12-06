package com.tsrosies.naturaltravel.ui.list

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tsrosies.naturaltravel.R
import com.tsrosies.naturaltravel.model.SitioNaturalItem

class SitioAdapter(
    private val sitiosList: ArrayList<SitioNaturalItem>,
    private val onItemClicked: (SitioNaturalItem)->Unit

)
    :RecyclerView.Adapter<SitioAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, Viewtype: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sitionatural=sitiosList[position]
        holder.itemView.setOnClickListener { onItemClicked(sitiosList[position]) }
        holder.bind(sitionatural)

    }
    override fun getItemCount(): Int = sitiosList.size

    fun appendItems(newItems: ArrayList<SitioNaturalItem>) {
        sitiosList.clear()
        sitiosList.addAll(newItems)
        notifyDataSetChanged()
    }
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
                Picasso.get().load(sitionatural.urlImagen).into(itemImageView)
        }
    }
}