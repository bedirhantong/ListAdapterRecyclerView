package com.bedirhan.denemerecyclerview.service

import com.bedirhan.denemerecyclerview.model.Product
import retrofit2.http.GET

interface ProductAPI {

    @GET("products/")
    suspend fun getProducts():ArrayList<Product>
}