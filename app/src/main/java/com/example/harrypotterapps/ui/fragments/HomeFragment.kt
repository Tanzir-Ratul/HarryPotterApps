package com.example.harrypotterapps.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
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
    private var backPressedTime: Long = 0
    private var harryAdapter: HarryPotterAdapter? = null
    private var isFirsApiCall = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (isFirsApiCall) harryViewModel.getCharacters()
        initInstanceAndView()
        onClick()
        setObserver()
    }

    private fun initInstanceAndView() {
        binding.harryRV.layoutManager =
            LinearLayoutManager(requireContext()) // Set the number of columns and orientation
        harryAdapter = HarryPotterAdapter(requireContext())
        binding.harryRV.adapter = harryAdapter

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            onBackPressedCallback
        )
    }

    private fun setObserver() {
        harryViewModel.apply {
            characters.observe(viewLifecycleOwner) {
                harryAdapter?.setData(it)
            }
            isLoading.observe(viewLifecycleOwner) {
                if (it) {
                    binding.progressBar.visibility = View.VISIBLE
                } else {
                    binding.progressBar.visibility = View.GONE
                }
            }
        }

    }

    private fun onClick() {
        harryAdapter?.itemClick = {
            val bundle = Bundle()
            bundle.putString("id", it)
            findNavController().navigate(R.id.action_homeFragment_to_detailsFragment, bundle)
        }
    }

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            if (shouldNavigateBack()) {
                requireActivity().finish()
            }
        }
    }

    private fun shouldNavigateBack(): Boolean {
        val currentTime = System.currentTimeMillis()

        if (currentTime - backPressedTime < 2000) { //  time interval for exit
            return true
        } else {
            backPressedTime = currentTime
            Toast.makeText(requireContext(), "Press back again to exit", Toast.LENGTH_LONG).show()
        }
        return false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        isFirsApiCall = false
        harryAdapter = null
    }

}