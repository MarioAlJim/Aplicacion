package com.teamxticket.nuevaapp.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.teamxticket.nuevaapp.data.model.Product
import com.teamxticket.nuevaapp.databinding.ItemProductBinding

class ProductAdapter (private val products: List<Product>, val onItemSelected: (Product) -> Unit ) :
                      RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemProductBinding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentProduct = products[position]
        with(holder.binding) {
            tvName.text = "Nombre: " + currentProduct.title
            tvDescription.text =  currentProduct.description
            tvPrice.text = "Precio: " + currentProduct.price.toString()

            holder.binding.root.setOnClickListener {
                onItemSelected(currentProduct)
            }
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }

}