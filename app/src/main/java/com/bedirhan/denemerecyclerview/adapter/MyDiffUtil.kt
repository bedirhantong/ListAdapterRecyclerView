package com.bedirhan.denemerecyclerview.adapter

import androidx.recyclerview.widget.DiffUtil
import com.bedirhan.denemerecyclerview.model.Product

class MyDiffUtil(
    private val oldList: List<Product>,
    private val newList: List<Product>,
) :DiffUtil.Callback()
{
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
       return when{
           oldList[oldItemPosition].id != newList[newItemPosition].id ->{
               false
           }
           oldList[oldItemPosition].title != newList[newItemPosition].title ->{
               false
           }
           oldList[oldItemPosition].image != newList[newItemPosition].image ->{
               false
           }
           oldList[oldItemPosition].category != newList[newItemPosition].category ->{
               false
           }
           else -> true
       }
    }

}