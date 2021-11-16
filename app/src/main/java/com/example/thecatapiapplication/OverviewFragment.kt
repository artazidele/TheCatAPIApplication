package com.example.thecatapiapplication

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.thecatapiapplication.databinding.FragmentOverviewBinding
import kotlin.coroutines.coroutineContext


class OverviewFragment : Fragment() {

    private val viewModel: OverviewViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOverviewBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.photosGrid.adapter = CatPhotoGridAdapter()//CatPhotoGridAdapter()
        return binding.root
    }
}