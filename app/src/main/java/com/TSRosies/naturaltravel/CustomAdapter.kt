package com.TSRosies.naturaltravel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter:RecyclerView.Adapter<CustomAdapter.ViewHolder>(){

    val titles= arrayOf("Sitio 1 natural a visitar","Sitio 2 natural a visitar","Sitio 3 natural a visitar","Sitio 4 natural a visitar" )

    val details = arrayOf("Detalle sitio 1","Detalle sitio 2","Detalle sitio 3","Detalle sitio 4")
    val puntaje = arrayOf(" puntaje 1"," puntaje 2"," puntaje 3"," puntaje 4")

    val images = intArrayOf(R.drawable.ecoparque_tigua,R.drawable.laguna_de_pedro_palo,
        R.drawable.parque_ecologico_pionono,R.drawable.parque_montana_oso)


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout,viewGroup, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = titles[i]
        viewHolder.itemDetail.text = details[i]
        viewHolder.itemPuntaje.text = puntaje[i]
        viewHolder.itemImage.setImageResource(images[i])

    }
    override fun getItemCount(): Int {
        return titles.size
            }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var itemImage:ImageView
        var itemTitle:TextView
        var itemDetail:TextView
        var itemPuntaje:TextView

        init{
            itemImage =itemView.findViewById(R.id.item_image)
            itemTitle=itemView.findViewById(R.id.item_title)
            itemDetail =itemView.findViewById(R.id.item_detail)
            itemPuntaje=itemView.findViewById(R.id.item_puntaje)
        }
    }
}