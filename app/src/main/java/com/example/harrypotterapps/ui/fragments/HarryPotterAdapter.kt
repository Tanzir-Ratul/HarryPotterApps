package com.example.harrypotterapps.ui.fragments

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.harrypotterapps.R
import com.example.harrypotterapps.api.model.MovieCharacters
import com.example.harrypotterapps.databinding.HarryPotterAdapterBinding

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
        holder.bind(harryPotterList[position])
    }

    fun setData(list: List<MovieCharacters.HarryPotterCharacters?>) {
        harryPotterList.clear()
        harryPotterList.addAll(list as List<MovieCharacters.HarryPotterCharacters>)
        notifyDataSetChanged()
    }

    inner class HarryPotterViewHolder(private val binding: HarryPotterAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MovieCharacters.HarryPotterCharacters) {
            //item.image?.let { cImageSet?.invoke(binding.characterIV, it) }
            try{
                Log.d("image", "bind: ${item.image}")
                if(item.image != null && item.image != "" ) {
                    Glide.with(binding.characterIV.context)
                        .load(item.image)
                        .placeholder(R.drawable.image_placeholder_loading)
                        .error(R.drawable.ic_error_message)
                        .into(binding.characterIV)
                }else{
                    binding.characterIV.setImageResource(R.drawable.ic_error_message)
                }
            }catch (e:Exception){
                binding.characterIV.setImageResource(R.drawable.ic_error_message)
                e.printStackTrace()
            }

            binding.charNameTV.text = if(!item.name.isNullOrEmpty()) item.name else "Not found"
            binding.realNameTV.text = if(!item.actor.isNullOrEmpty()) "Name: ${item.actor}" else "Name: Not found"
            binding.houseNameTV.text = if(!item.house.isNullOrEmpty()) "House: ${item.house}" else "House: Not Found"
            itemView.setOnClickListener {
                item.id?.let { it1 -> itemClick?.invoke(it1) }
            }
        }


    }
}