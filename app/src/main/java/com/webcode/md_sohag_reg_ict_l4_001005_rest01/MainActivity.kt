package com.webcode.md_sohag_reg_ict_l4_001005_rest01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ProductViewModel
    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[ProductViewModel::class.java]



        productAdapter = ProductAdapter(emptyList())

        findViewById<RecyclerView>(R.id.recyclerView).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = productAdapter
        }

        observeViewModel()
        viewModel.fetchProducts()
    }

    private fun observeViewModel() {
        viewModel.products.observe(this, { products ->
            productAdapter = ProductAdapter(products)
            findViewById<RecyclerView>(R.id.recyclerView).adapter = productAdapter
        })
    }
}