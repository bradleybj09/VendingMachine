package com.example.vendingmachine

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.vendingmachine.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ProductGridAdapter.OnItemClickListener {

    lateinit var viewModel: MainViewModel
    lateinit var adapter: ProductGridAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerviewProductGrid.layoutManager = GridLayoutManager(this, 4)
        adapter = ProductGridAdapter(arrayListOf(), this, this)
        binding.recyclerviewProductGrid.adapter = adapter
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        adapter.replaceData(viewModel.products)
    }

    override fun onItemClick(position: Int) {
        viewModel.purchaseProduct(position)
    }
}
