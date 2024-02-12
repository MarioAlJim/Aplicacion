package com.teamxticket.nuevaapp.data.network

import com.teamxticket.nuevaapp.core.RetrofitHelper
import com.teamxticket.nuevaapp.data.model.Products
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.SocketTimeoutException

class ProductService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getProducts(): Products {
        return withContext(Dispatchers.IO) {
            try {
                val response = retrofit.create(ProductsApiClient::class.java).getProducts()
                response.body() ?: Products(0, emptyList(), 0, 0)
            } catch (e: SocketTimeoutException) {
                throw SocketTimeoutException("Can not connect with server")
            }
        }
    }
}