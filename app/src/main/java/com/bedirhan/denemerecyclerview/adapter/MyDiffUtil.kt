package com.bedirhan.denemerecyclerview.adapter

import androidx.recyclerview.widget.DiffUtil
import com.bedirhan.denemerecyclerview.model.User

class MyDiffUtil(
    private val oldList: List<User>,
    private val newList: List<User>,
) :DiffUtil.Callback()
{
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].name == newList[newItemPosition].name
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
       return when{
           oldList[oldItemPosition].name != newList[newItemPosition].name ->{
               false
           }
           oldList[oldItemPosition].age != newList[newItemPosition].age ->{
               false
           }
           else -> true
       }
    }

}