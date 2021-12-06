package com.tsrosies.naturaltravel.data


import com.tsrosies.naturaltravel.model.SitioNatural
import retrofit2.http.GET

interface ApiService {

    @GET("tsrosies.naturaltravel.SitioNat")
    suspend fun getSitiosnaturales(): SitioNatural

}