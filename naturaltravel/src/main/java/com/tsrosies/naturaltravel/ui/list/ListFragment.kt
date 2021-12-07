package com.tsrosies.naturaltravel.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tsrosies.naturaltravel.databinding.FragmentListBinding
import com.tsrosies.naturaltravel.ui.list.ListFragmentDirections
import com.tsrosies.naturaltravel.ui.main.MainActivity
import com.tsrosies.naturaltravel.model.SitioNaturalItem


class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel
    private lateinit var sitiosNaturalesAdapter: SitioAdapter
    private var listSitiosnaturales: ArrayList<SitioNaturalItem> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]
        return listBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()
     //   listViewModel.loadMockSitioNaturalFromJson(context?.assets?.open("sitionatural.json"))

        listViewModel.getSitiosnaturalesFromServer()

        listViewModel.onSitiosnaturalesLoaded.observe(viewLifecycleOwner, { result ->
            onSitiosnaturalesLoadedSubscribe(result)
        })

        sitiosNaturalesAdapter = SitioAdapter(listSitiosnaturales, onItemClicked = { onSitionaturalClicked(it) } )

        listBinding.SitioNaturalRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = sitiosNaturalesAdapter
            setHasFixedSize(false)
        }
    }

    private fun onSitiosnaturalesLoadedSubscribe(result: ArrayList<SitioNaturalItem>?) {
        result?.let { listSitiosnaturales->
            sitiosNaturalesAdapter.appendItems(listSitiosnaturales)
            /*
            // TODO: revisar feedback
            this.listSitiosnaturales = listSitiosnaturales
            SitiosAdapter.notifyDataSetChanged()
            */
        }
    }

    private fun onSitionaturalClicked(sitionatural: SitioNaturalItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(sitionatural= sitionatural))
    }
}


