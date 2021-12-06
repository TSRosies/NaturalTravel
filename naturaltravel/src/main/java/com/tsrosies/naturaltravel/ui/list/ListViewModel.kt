package com.tsrosies.naturaltravel.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tsrosies.naturaltravel.model.SitioNatural
import com.tsrosies.naturaltravel.model.SitioNaturalItem
import com.google.gson.Gson
import com.tsrosies.naturaltravel.data.SitiosnaturalesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.InputStream

class ListViewModel : ViewModel() {

    private var sitiosnaturalesLoad : MutableLiveData<ArrayList<SitioNaturalItem>> = MutableLiveData()
    val onSitiosnaturalesLoaded: LiveData<ArrayList<SitioNaturalItem>> = sitiosnaturalesLoad

    private val repository = SitiosnaturalesRepository()

    fun getSitiosnaturalesFromServer(){
        GlobalScope.launch(Dispatchers.IO) {
            sitiosnaturalesLoad.postValue(repository.getSitiosnaturales())
        }
    }

    fun loadMockSitioNaturalFromJson(sitiosNaturalesString: InputStream?) {
        val sitiosNaturalesString = sitiosNaturalesString?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        sitiosnaturalesLoad.value = gson.fromJson(sitiosNaturalesString, SitioNatural::class.java)
    }
}