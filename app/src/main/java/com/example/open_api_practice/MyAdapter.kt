package com.example.open_api_practice

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.open_api_practice.databinding.ItemLayoutBinding

class MyAdapter(private val viewModel: MyViewModel) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>()
{
    inner class ViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)
    {
            fun setContents(pos: Int){
                with(viewModel.items[pos]){
                    binding.textView.text = homename
                    binding.textView2.text = price
                }
            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
        //val layoutInflater = LayoutInflater.from(parent.context)
        // val binding = ItemLayoutBinding.inflate(layoutInflater,parent,false)
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setContents(position)
    }

    override fun getItemCount(): Int = viewModel.items.size
}