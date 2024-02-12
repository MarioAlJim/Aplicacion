package com.teamxticket.nuevaapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teamxticket.nuevaapp.data.ProductUseCase
import com.teamxticket.nuevaapp.data.ProductsRepository
import com.teamxticket.nuevaapp.data.model.Product
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val repository = ProductsRepository()
    var productsUseCase = ProductUseCase()
    var products = MutableLiveData<List<Product>>()

    fun loadProducts () {
        viewModelScope.launch {
            val response = productsUseCase.getProducts()
            products.postValue(response.products)
        }
    }
}