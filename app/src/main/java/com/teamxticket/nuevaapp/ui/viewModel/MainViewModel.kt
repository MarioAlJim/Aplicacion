package com.teamxticket.nuevaapp.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teamxticket.nuevaapp.domain.ProductUseCase
import com.teamxticket.nuevaapp.data.model.Product
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private var productsUseCase = ProductUseCase()
    private var _products = MutableLiveData<List<Product>>()
    val products get() = _products

    fun loadProducts () {
        viewModelScope.launch {
            val response = productsUseCase.getProducts()
            products.postValue(response)
        }
    }
}