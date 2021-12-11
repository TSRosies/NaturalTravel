package com.tsrosies.naturaltravel.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SitioNaturalItem(
    @SerializedName("nombre")
    val nombre: String,
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
    @SerializedName("puntaje")
    val puntaje: String,
    @SerializedName("urlImagen")
    val urlImagen: String,
    @SerializedName("urlImagen1")
    val urlImagen1: String,
    @SerializedName("urlImagen2")
    val urlImagen2: String,
    @SerializedName("latitud")
    val latitud: Double,
    @SerializedName("longitud")
    val longitud: Double
):  Serializable
