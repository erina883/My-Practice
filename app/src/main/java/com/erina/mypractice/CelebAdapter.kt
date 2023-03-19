package com.example.recycleview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.erina.mypractice.FullActivity
import com.erina.mypractice.databinding.ItemCelebBinding


class CelebAdapter(var context:Context) :ListAdapter<Celeb, CelebViewHolder>(comparator) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CelebViewHolder {

        val binding = ItemCelebBinding.inflate(LayoutInflater.from(context), parent, false)
        return CelebViewHolder(binding)

    }

    override fun onBindViewHolder(holder: CelebViewHolder, position: Int) {
        getItem(position).let {

            with(holder.binding) {
                name.text = it.name
                bio.text = it.bio

                Glide.with(context)
                    .load(it.profileImage)
                    .into(profileImg)
            }



            holder.itemView.setOnClickListener {_ ->
                val intent = Intent(context, FullActivity::class.java)
                intent.putExtra("img", it.profileImage)
                context.startActivity(intent)
            }


        }
    }


    companion object{
        val comparator = object : DiffUtil.ItemCallback<Celeb>(){
            override fun areItemsTheSame(oldItem: Celeb, newItem: Celeb): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Celeb, newItem: Celeb): Boolean {
               return oldItem == newItem
            }
        }
    }

}