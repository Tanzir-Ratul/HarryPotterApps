package com.example.harrypotterapps.ui.fragments

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.harrypotterapps.api.model.HarryPotterCharacters
import com.example.harrypotterapps.databinding.HarryPotterAdapterBinding

class HarryPotterAdapter(mContext: Context) :
    RecyclerView.Adapter<HarryPotterAdapter.HarryPotterViewHolder>() {

    private var harryPotterList = mutableListOf<HarryPotterCharacters>()
    var cImageSet: ((ImageView, String) -> Unit)? = null
    var itemClick: ((String) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HarryPotterViewHolder {
        return HarryPotterViewHolder(
            HarryPotterAdapterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return harryPotterList.size
    }

    override fun onBindViewHolder(holder: HarryPotterViewHolder, position: Int) {
        holder.bind(harryPotterList[position], position)
    }

    fun setData(list: List<HarryPotterCharacters?>) {
        harryPotterList.clear()
        harryPotterList.addAll(list as List<HarryPotterCharacters>)
        notifyDataSetChanged()
    }

    inner class HarryPotterViewHolder(val binding: HarryPotterAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HarryPotterCharacters, position: Int) {
            item.image?.let { cImageSet?.invoke(binding.characterIV, it) }

            itemView.setOnClickListener {
                item.id?.let { it1 -> itemClick?.invoke(it1) }
            }
        }


    }
}