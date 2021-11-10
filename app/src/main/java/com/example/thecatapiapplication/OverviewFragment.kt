package com.example.thecatapiapplication

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import com.example.thecatapiapplication.databinding.FragmentOverviewBinding


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




    public fun openImageWindow(item: MenuItem) {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.rate_cat_photo_window, null)
        val builder = AlertDialog.Builder(context)
            .setView(dialogView)
        val alertDialog = builder.show()

        dialogView.findViewById<Button>(R.id.cancel_button).setOnClickListener {
            alertDialog.dismiss()
        }
    }
}