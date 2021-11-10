package com.example.thecatapiapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.thecatapiapplication.databinding.GridViewItemBinding

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
    }
}