package com.teamxticket.nuevaapp.data

class ProductUseCase {

    private val repository = ProductsRepository()

    suspend fun getProducts() = repository.getProducts()

}