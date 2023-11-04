package com.example.harrypotterapps.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.harrypotterapps.R
import com.example.harrypotterapps.api.model.CharacterDetails
import com.example.harrypotterapps.databinding.FragmentDetailsBinding
import com.example.harrypotterapps.ui.viewmodels.HarryPotterViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private lateinit var id:String
    private val detailsViewModel: HarryPotterViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetailsBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        id = arguments?.getString("id").toString() ?: ""
        Log.d("helloMAn", id.toString())
        detailsViewModel.getCharacterDetails(id)//call details api

        onClick()
        setObserver()
    }

    private fun setObserver() {
        detailsViewModel.apply {
            starDetails.observe(viewLifecycleOwner){
                if (it != null){
                    initView(it[0])
                }
            }
            isLoading.observe(viewLifecycleOwner){
                if(it){
                    binding.progressBar.visibility = View.VISIBLE
                    binding.mainCL.visibility = View.GONE
                }else{
                    binding.progressBar.visibility = View.GONE
                    binding.mainCL.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun onClick() {
       binding.backBtn.setOnClickListener {
           findNavController().popBackStack()
       }
    }

    private fun initView(item: CharacterDetails.MovieCharDetails) {
        try{
            if((item.image != null) && item.image!!.isNotEmpty()){
                Picasso.get()
                    .load(item.image)
                    .placeholder(R.drawable.image_placeholder_loading)
                    //.memoryPolicy(MemoryPolicy.NO_STORE)
                    //.networkPolicy(NetworkPolicy.NO_STORE)
                    .error(R.drawable.ic_error_message)
                    .into(binding.imageView)
            }
        }catch (e:Exception){
            binding.imageView.setImageResource(R.drawable.ic_error_message)
            e.printStackTrace()
        }
        binding.characterNameTV.text = item.name
        binding.originalNameTV.text = item.actor
        binding.houseNameTV.text = item.house
        binding.genderTV.text = item.gender
        binding.dobTV.text = item.dateOfBirth
    }


}