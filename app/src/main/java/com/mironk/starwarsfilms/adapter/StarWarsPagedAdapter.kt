package com.mironk.starwarsfilms.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mironk.starwarsfilms.databinding.CharacterNameBinding
import com.mironk.starwarsfilms.model.StarWars

class StarWarsPagedAdapter(private val cl : StarWarsClickListener) :
    PagingDataAdapter<StarWars, StarWarsPagedAdapter.MyViewHolder>(diffCallback) {


    class MyViewHolder(val binding: CharacterNameBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: StarWars, clickListener: (StarWars) -> Unit) {
            itemView.setOnClickListener { clickListener(data) }
        }
    }

    companion object {

        private val diffCallback = object : DiffUtil.ItemCallback<StarWars>() {
            override fun areItemsTheSame(
                oldItem: StarWars, newItem: StarWars
            ): Boolean = oldItem.count == newItem.count


            override fun areContentsTheSame(
                oldItem: StarWars, newItem: StarWars
            ): Boolean = oldItem == newItem

        }
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val post = getItem(position)

        holder.bind(post!!, cl.clickListener)

        holder.binding.apply {

            name.text = post.name

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            CharacterNameBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }
}

data class StarWarsClickListener(val clickListener: (wallpaper: StarWars) -> Unit)