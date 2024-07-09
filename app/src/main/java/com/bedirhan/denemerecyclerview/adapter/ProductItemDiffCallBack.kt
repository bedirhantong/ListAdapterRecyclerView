package com.bedirhan.denemerecyclerview.adapter

import androidx.recyclerview.widget.DiffUtil
import com.bedirhan.denemerecyclerview.model.Product

class ProductItemDiffCallBack() :DiffUtil.ItemCallback<Product>()
{
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
    return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return when{
            oldItem.id != newItem.id ->{
                false
            }
            oldItem.title != newItem.title ->{
                false
            }
            oldItem.category != newItem.category ->{
                false
            }
            oldItem.image != newItem.image ->{
                false
            }
            oldItem.description != newItem.description ->{
                false
            }
            oldItem.price != newItem.price ->{
                false
            }
            oldItem.rating != newItem.rating ->{
                false
            }

            else -> true
        }
    }

}