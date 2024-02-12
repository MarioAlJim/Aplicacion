package com.teamxticket.nuevaapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.teamxticket.nuevaapp.R
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.teamxticket.nuevaapp.data.model.Product
import com.teamxticket.nuevaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.rvProducts.layoutManager = LinearLayoutManager(this)
        setContentView(binding.root)

        initObservables()
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadProducts()
    }

    private fun initObservables() {
        viewModel.products.observe(this) { products ->
            val productList : List<Product> = products ?: emptyList()
            val adapter = ProductAdapter(productList) { product -> onItemSelected(product) }
            binding.rvProducts.adapter = adapter
        }
    }

    private fun onItemSelected(product: Product) {
        Intent(this, ProductDetailActivity::class.java).apply {
            putExtra("product", product)
            startActivity(this)
        }
    }
}