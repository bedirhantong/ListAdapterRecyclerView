package com.bedirhan.denemerecyclerview.service

import com.bedirhan.denemerecyclerview.model.Product
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductAPIService {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://fakestoreapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ProductAPI::class.java)


    suspend fun getProductsFromRemote() : ArrayList<Product>{
        return retrofit.getProducts()
    }
}