package com.bedirhan.denemerecyclerview.view.home.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bedirhan.denemerecyclerview.model.Product
import com.bedirhan.denemerecyclerview.service.ProductAPIService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _productList = MutableLiveData<List<Product>>()
    val productList : LiveData<List<Product>>
        get() = _productList

    private val productApiService = ProductAPIService()


    private fun getRemoteAlbums(){
        viewModelScope.launch (Dispatchers.Main){
            val albums = productApiService.getProductsFromRemote()
            showAlbums(albums)
        }


    }

    fun getDataFromInternetDirectly(){
        getRemoteAlbums()
    }

    private fun showAlbums(albums : List<Product>){
        _productList.value = albums
    }

}