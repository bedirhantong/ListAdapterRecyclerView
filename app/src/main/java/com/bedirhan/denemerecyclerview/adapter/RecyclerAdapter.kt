package com.bedirhan.denemerecyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bedirhan.denemerecyclerview.model.User
import com.bedirhan.denemerecyclerview.databinding.RecyclerRowBinding

class RecyclerAdapter:RecyclerView.Adapter<RecyclerAdapter.RecycleViewHolder>() {
    private var userList:List<User> = arrayListOf()

    inner class RecycleViewHolder(
        private val binding: RecyclerRowBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(user: User){
            binding.rowUsername.text = user.name
            binding.rowUserAge.text = user.age.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {
        val binding = RecyclerRowBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        )
        return RecycleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
        holder.bind(
            userList[position]
        )
    }


    fun setData(newList: List<User>){
        val diffUtil = MyDiffUtil(userList,newList)
        val diffResults = DiffUtil.calculateDiff(diffUtil)
        userList = newList
        diffResults.dispatchUpdatesTo(this)
    }
}