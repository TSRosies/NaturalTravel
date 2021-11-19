package com.TSRosies.naturaltravel

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

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
        private var itemTitleTextView:TextView = itemView.findViewById(R.id.item_title)
        private var itemDetailTextView:TextView = itemView.findViewById(R.id.item_detail)
        private var itemPuntajeTextView:TextView = itemView.findViewById(R.id.item_puntaje)



            fun bind(sitionatural: SitioNaturalItem){
                Log.d("nombre",sitionatural.nombre)
                itemTitleTextView.text= sitionatural.nombre
                itemDetailTextView.text = sitionatural.descripcion
                itemPuntajeTextView.text = sitionatural.puntaje
                Picasso.get().load(sitionatural.url).into(itemImageView)
        }
    }
}