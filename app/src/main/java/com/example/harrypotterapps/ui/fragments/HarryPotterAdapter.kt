package com.example.harrypotterapps.ui.fragments

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.harrypotterapps.R
import com.example.harrypotterapps.api.model.MovieCharacters
import com.example.harrypotterapps.databinding.HarryPotterAdapterBinding
import com.squareup.picasso.Picasso

class HarryPotterAdapter(mContext: Context) :
    RecyclerView.Adapter<HarryPotterAdapter.HarryPotterViewHolder>() {

    private var harryPotterList = mutableListOf<MovieCharacters.HarryPotterCharacters>()
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

    fun setData(list: List<MovieCharacters.HarryPotterCharacters?>) {
        harryPotterList.clear()
        harryPotterList.addAll(list as List<MovieCharacters.HarryPotterCharacters>)
        notifyDataSetChanged()
    }

    inner class HarryPotterViewHolder(private val binding: HarryPotterAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MovieCharacters.HarryPotterCharacters, position: Int) {
            //item.image?.let { cImageSet?.invoke(binding.characterIV, it) }
            try{
                if(item.image != null && item.image != "" ){
                    Picasso.get()
                        .load(item.image)
                        .placeholder(R.drawable.image_placeholder_loading)
                        //.memoryPolicy(MemoryPolicy.NO_STORE)
                        //.networkPolicy(NetworkPolicy.NO_STORE)
                        .error(R.drawable.ic_error_message)
                        .into(binding.characterIV)
                }
            }catch (e:Exception){
                binding.characterIV.setImageResource(R.drawable.ic_error_message)
                e.printStackTrace()
            }
            itemView.setOnClickListener {
                item.id?.let { it1 -> itemClick?.invoke(it1) }
            }
        }


    }
}