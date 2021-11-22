package com.TSRosies.naturaltravel.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SitioNaturalItem(
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("descripcion2")
    val descripcion2: String,
    @SerializedName("ubicacion")
    val ubicacion: String,
    @SerializedName("temperatura")
    val temperatura: String,
    @SerializedName("actividades")
    val actividades: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("puntaje")
    val puntaje: String,
    @SerializedName("urlImagen")
    val urlImagen: String,
    @SerializedName("urlImagen1")
    val urlImagen1: String,
    @SerializedName("urlImagen2")
    val urlImagen2: String
):  Serializable
