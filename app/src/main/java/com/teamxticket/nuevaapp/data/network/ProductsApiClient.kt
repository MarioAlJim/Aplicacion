package com.teamxticket.nuevaapp.data.network

import com.teamxticket.nuevaapp.data.model.Products
import retrofit2.Response
import retrofit2.http.GET

interface ProductsApiClient {
    @GET("products")
    suspend fun getProducts(): Response<Products>
}