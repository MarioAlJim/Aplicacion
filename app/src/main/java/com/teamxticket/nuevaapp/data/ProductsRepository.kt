package com.teamxticket.nuevaapp.data

import com.teamxticket.nuevaapp.data.network.ProductService

class ProductsRepository {

    private val productService = ProductService()

    suspend fun getProducts() = productService.getProducts()

}