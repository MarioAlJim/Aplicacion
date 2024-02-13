package com.teamxticket.nuevaapp.domain

import com.teamxticket.nuevaapp.data.ProductsRepository

class ProductUseCase {

    private val repository = ProductsRepository()

    suspend fun getProducts() = repository.getProducts()

}