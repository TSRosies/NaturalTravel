package com.tsrosies.naturaltravel.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.tsrosies.naturaltravel.databinding.FragmentListBinding
import com.tsrosies.naturaltravel.model.SitioNatural
import com.tsrosies.naturaltravel.model.SitioNaturalItem


class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var sitiosAdapter: SitioAdapter
    private lateinit var listSitios: ArrayList<SitioNaturalItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)

        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listSitios = loadMockSitiosNaturalesFromJson()
        sitiosAdapter = SitioAdapter(listSitios, onItemClicked = {onSitionaturalClicked(it)})
        listBinding.SitioNaturalRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = sitiosAdapter
            setHasFixedSize(false)
        }
    }

    private fun onSitionaturalClicked(sitionatural: SitioNaturalItem) {

        //TODO programar detalle
    }

    private fun loadMockSitiosNaturalesFromJson(): ArrayList<SitioNaturalItem>{
        val sitioNaturalString:String = context?.assets?.open("sitionatural.json")?.bufferedReader().use{it!!.readText()} //TODO pendiente modificar !!
        val gson = Gson()
        val data = gson.fromJson(sitioNaturalString, SitioNatural::class.java)
        return data
    }


}