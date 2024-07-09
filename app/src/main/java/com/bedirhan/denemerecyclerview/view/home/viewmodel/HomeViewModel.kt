package com.bedirhan.denemerecyclerview.view.home.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bedirhan.denemerecyclerview.model.User

class HomeViewModel : ViewModel() {
    private val _userList = MutableLiveData<List<User>>()
    val userList : LiveData<List<User>>
        get() = _userList

    init {
        Log.d("viewModel","you are in homeViewModel")
    }

    fun showUsers(){
        // remote data logic
        _userList.value = arrayListOf(
            User("Bedirhan",23),
            User("Mehmet",23),
            User("Ali",23),
            User("Mesut",23),
            User("Anıl",23),
            User("Tuba",23),
            User("Alara",23),
            User("Ayşe",23),
            User("Appcent",11)
        )
    }

}