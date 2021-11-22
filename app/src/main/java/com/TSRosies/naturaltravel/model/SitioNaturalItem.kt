package com.TSRosies.naturaltravel.model


import com.google.gson.annotations.SerializedName

data class SitioNaturalItem(
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("puntaje")
    val puntaje: String,
    @SerializedName("url")
    val urlPicture: String
)