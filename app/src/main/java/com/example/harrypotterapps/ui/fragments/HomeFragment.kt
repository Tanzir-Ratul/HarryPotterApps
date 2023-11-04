package com.example.harrypotterapps.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.harrypotterapps.R
import com.example.harrypotterapps.databinding.FragmentHomeBinding
import com.example.harrypotterapps.ui.viewmodels.HarryPotterViewModel
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val harryViewModel: HarryPotterViewModel by viewModels()

    private lateinit var harryAdapter: HarryPotterAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        harryViewModel.getCharacters()
        initInstanceAndView()
        onClick()
        setObserver()
    }

    private fun setObserver() {
         harryViewModel.apply {
             characters.observe(viewLifecycleOwner) {
                harryAdapter.setData(it)
            }
             isLoading.observe(viewLifecycleOwner){
                    if(it){
                        binding.progressBar.visibility = View.VISIBLE
                    }else{
                        binding.progressBar.visibility = View.GONE
                    }
             }
         }

    }

    private fun onClick() {
      harryAdapter.cImageSet = {imageView,imageUrl->
          try{
              if(imageUrl!=null && imageUrl.isNotEmpty()){
                  Picasso.get()
                      .load(imageUrl)
                      .placeholder(R.drawable.image_placeholder_loading)
                      //.memoryPolicy(MemoryPolicy.NO_STORE)
                      //.networkPolicy(NetworkPolicy.NO_STORE)
                      .error(R.drawable.ic_error_message)
                      .into(imageView)
              }
          }catch (e:Exception){
              imageView.setImageResource(R.drawable.ic_error_message)
              e.printStackTrace()
          }
      }
        harryAdapter.itemClick = {
            val bundle = Bundle()
            bundle.putString("id",it)
            findNavController().navigate(R.id.action_homeFragment_to_detailsFragment,bundle)
        }
    }

    private fun initInstanceAndView() {
        binding.harryRV.layoutManager = StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL) // Set the number of columns and orientation
        harryAdapter = HarryPotterAdapter(requireContext())
        binding.harryRV.adapter = harryAdapter

    }

}