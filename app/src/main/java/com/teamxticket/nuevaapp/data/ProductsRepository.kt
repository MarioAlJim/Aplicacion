package com.teamxticket.nuevaapp.data

import com.teamxticket.nuevaapp.data.model.Product
import com.teamxticket.nuevaapp.data.network.ProductService

class ProductsRepository {

    private val productService = ProductService()
    private var products: List<Product> = listOf()
    suspend fun getProducts() : List<Product> {
        if(products.isEmpty()) {
            var result = productService.getProducts()
            products = result.products
            return products
        }
        return products
    }

}