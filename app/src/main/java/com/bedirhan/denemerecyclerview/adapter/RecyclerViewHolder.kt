package com.bedirhan.denemerecyclerview.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bedirhan.denemerecyclerview.R
import com.bedirhan.denemerecyclerview.databinding.RecyclerRowBinding
import com.bedirhan.denemerecyclerview.model.Product
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class RecyclerViewHolder(
    private val binding: RecyclerRowBinding
) : RecyclerView.ViewHolder(binding.root) {

    private fun customizedPlaceHolder (): CircularProgressDrawable {
        return  CircularProgressDrawable(binding.root.context).apply {
            strokeWidth = 8f
            centerRadius = 40f
            start()
        }
    }

    private val options = RequestOptions()
        .placeholder(customizedPlaceHolder()).fitCenter().error(R.mipmap.ic_launcher)
    fun bind(product: Product){
        binding.rowProductTitle.text = product.title
        binding.rowProductDescription.text = product.description
        Glide.with(binding.rowImage.context).setDefaultRequestOptions(options).load(product.image).into(binding.rowImage)

    }
}