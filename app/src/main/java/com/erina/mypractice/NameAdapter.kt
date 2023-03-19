package com.erina.mypractice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.erina.mypractice.databinding.ItemNameBinding



class NameAdapter: ListAdapter<String, NameViewHolder>(comparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        val binding = ItemNameBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NameViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        getItem(position).let {
            holder.binding.nametv.text = it
        }
    }

    companion object{
        val comparator = object : DiffUtil.ItemCallback<String>(){
            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

        }
    }
}