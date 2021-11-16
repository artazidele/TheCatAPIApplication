package com.example.thecatapiapplication

import android.app.AlertDialog
import android.app.PendingIntent.getActivity
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentViewHolder
import com.bumptech.glide.Glide
import com.example.thecatapiapplication.databinding.GridViewItemBinding
import java.security.AccessController.getContext
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

class CatPhotoGridAdapter :
    ListAdapter<CatPhoto, CatPhotoGridAdapter.CatPhotosViewHolder>(DiffCallback) {
    class CatPhotosViewHolder(
        private var binding: GridViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(catPhoto: CatPhoto) {
            binding.photo = catPhoto
            binding.executePendingBindings()
        }
    }
    companion object DiffCallback : DiffUtil.ItemCallback<CatPhoto>() {
        override fun areItemsTheSame(oldItem: CatPhoto, newItem: CatPhoto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CatPhoto, newItem: CatPhoto): Boolean {
            return oldItem.url == newItem.url
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CatPhotosViewHolder {
        return CatPhotosViewHolder(
            GridViewItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }
    override fun onBindViewHolder(holder: CatPhotosViewHolder, position: Int) {
        val catPhoto = getItem(position)
        holder.bind(catPhoto)
        holder.itemView.setOnClickListener {
            openImageWindow(catPhoto, holder.itemView.context)
        }

    }
    private fun openImageWindow(catPhoto: CatPhoto, context: Context) {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.rate_cat_photo_window, null)
        val builder = AlertDialog.Builder(context)
            .setView(dialogView)
        val alertDialog = builder.show()
        val catImage = dialogView.findViewById<ImageView>(R.id.cat_image_view)
        Glide.with(context)
            .load(catPhoto.url)
            .into(catImage)
        dialogView.findViewById<Button>(R.id.rate_positive_button).setOnClickListener {
            Toast.makeText(context, "You rated positive.", Toast.LENGTH_SHORT).show()
        }
        dialogView.findViewById<Button>(R.id.rate_negative_button).setOnClickListener {
            Toast.makeText(context, "You rated negative.", Toast.LENGTH_SHORT).show()
        }
        dialogView.findViewById<Button>(R.id.cancel_button).setOnClickListener {
            alertDialog.dismiss()
        }
    }

}