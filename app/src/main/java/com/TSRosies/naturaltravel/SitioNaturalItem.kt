package com.TSRosies.naturaltravel


import com.google.gson.annotations.SerializedName

data class SitioNaturalItem(
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("puntaje")
    val puntaje: String,
    @SerializedName("url")
    val url: String
)