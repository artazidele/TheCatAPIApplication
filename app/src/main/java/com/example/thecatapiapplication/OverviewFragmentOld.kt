//package com.example.thecatapiapplication
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.viewModels
//
//class OverviewFragmentOld  : Fragment() {
//
//    private val viewModel: OverviewViewModel by viewModels()
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val binding = FragmentOverviewBinding.inflate(inflater)
//        binding.lifecycleOwner = this
//        binding.viewModel = viewModel
//        binding.photosGrid.adapter = CatPhotoGridAdapter()
//        return binding.root
//    }
//}