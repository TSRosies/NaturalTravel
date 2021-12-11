package com.tsrosies.naturaltravel.data

class SitiosnaturalesRepository {
    suspend fun getSitiosNaturales() = ApiFactory.retrofit.getSitiosnaturales()
}