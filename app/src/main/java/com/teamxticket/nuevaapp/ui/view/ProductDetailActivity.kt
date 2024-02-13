package com.teamxticket.nuevaapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import com.teamxticket.nuevaapp.R.string
import com.teamxticket.nuevaapp.data.model.Product
import com.teamxticket.nuevaapp.databinding.ActivityProductDetailBinding

class ProductDetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityProductDetailBinding
    private lateinit var product : Product
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        product = intent.getSerializableExtra("product") as Product

        initUI()
        initListeners()
    }

    private fun initListeners() {
        binding.bReturn.setOnClickListener {
            finish()
        }
    }

    private fun initUI() {
        binding.tvDescription.text = product.description
        binding.tvName.text = product.title
        "${getString(string.price)} ${product.price}".also { binding.tvPrice.text = it }
        var url = product.thumbnail
        Picasso.get().load(url).into(binding.ivProduct)
    }
}