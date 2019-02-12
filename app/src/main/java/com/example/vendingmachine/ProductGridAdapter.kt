package com.example.vendingmachine

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.vendingmachine.databinding.GridItemBinding

class ProductGridAdapter(private var products: List<Product>,
                         private var listener: OnItemClickListener,
                         private val lifecycleOwner: LifecycleOwner
) : RecyclerView.Adapter<ProductGridAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = GridItemBinding.inflate(layoutInflater, parent, false)
        binding.lifecycleOwner = lifecycleOwner
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position], listener)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun replaceData(products: List<Product>) {
        this.products = products
        notifyDataSetChanged()
    }

    class ProductViewHolder(var binding: GridItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product, listener: OnItemClickListener) {
            binding.product = product
            binding.root.setOnClickListener { listener.onItemClick(layoutPosition) }
            binding.executePendingBindings()
        }
    }
}