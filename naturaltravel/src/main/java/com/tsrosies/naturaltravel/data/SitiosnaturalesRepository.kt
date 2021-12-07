package com.tsrosies.naturaltravel.data

class SitiosnaturalesRepository {
    suspend fun getSitiosnaturales() = ApiFactory.retrofit.getSitiosnaturales()
}