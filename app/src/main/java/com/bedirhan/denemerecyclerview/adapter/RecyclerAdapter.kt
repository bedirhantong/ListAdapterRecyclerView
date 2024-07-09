package com.bedirhan.denemerecyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bedirhan.denemerecyclerview.R
import com.bedirhan.denemerecyclerview.databinding.RecyclerRowBinding
import com.bedirhan.denemerecyclerview.model.Product
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class RecyclerAdapter:RecyclerView.Adapter<RecyclerAdapter.RecycleViewHolder>() {
    private var productList:List<Product> = arrayListOf()

    inner class RecycleViewHolder(
        private val binding: RecyclerRowBinding
    ): RecyclerView.ViewHolder(binding.root){
        private val options = RequestOptions().placeholder(customizedPlaceHolder(itemView.context)).fitCenter().error(R.mipmap.ic_launcher)
        fun bind(product: Product){
            binding.rowProductTitle.text = product.title
            binding.rowProductDescription.text = product.description
            Glide.with(binding.rowImage.context).setDefaultRequestOptions(options).load(product.image).into(binding.rowImage)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {
        val binding = RecyclerRowBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        )
        return RecycleViewHolder(binding)
    }

    fun customizedPlaceHolder (context: Context): CircularProgressDrawable {
        return  CircularProgressDrawable(context).apply {
            strokeWidth = 8f
            centerRadius = 40f
            start()
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
        holder.bind(
            productList[position]
        )
    }


    fun setData(newList: List<Product>){
        val diffUtil = MyDiffUtil(productList,newList)
        val diffResults = DiffUtil.calculateDiff(diffUtil)
        productList = newList
        diffResults.dispatchUpdatesTo(this)
    }
}