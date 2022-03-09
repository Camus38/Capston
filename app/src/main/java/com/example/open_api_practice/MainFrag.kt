package com.example.open_api_practice

import android.content.Context
import android.os.Bundle
import android.view.ContextMenu
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.open_api_practice.databinding.FragmentMainBinding


class MainFrag : Fragment() {
    lateinit var binding : FragmentMainBinding
    private lateinit var viewmodel : MyViewModel
    var mainActivity : MainActivity? = null



    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewmodel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory())
            .get(MyViewModel::class.java)

        binding = FragmentMainBinding.inflate(inflater,container,false)
        val adapter = MyAdapter(viewmodel)

        binding.recycleView.layoutManager = LinearLayoutManager(requireContext(),
            RecyclerView.VERTICAL,false)
        binding.recycleView.setHasFixedSize(true)
        binding.recycleView.adapter=adapter

        viewmodel.itemsListData.observe(viewLifecycleOwner){
            adapter.notifyDataSetChanged()
        }


        return binding.root

    }


    fun setValue(value: String){

    }


}