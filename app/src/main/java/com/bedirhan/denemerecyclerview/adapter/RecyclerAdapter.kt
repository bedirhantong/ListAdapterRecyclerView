package com.bedirhan.denemerecyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bedirhan.denemerecyclerview.databinding.RecyclerRowBinding
import com.bedirhan.denemerecyclerview.model.Product

class RecyclerAdapter: ListAdapter<Product,RecyclerViewHolder>(ProductItemDiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(
            RecyclerRowBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}