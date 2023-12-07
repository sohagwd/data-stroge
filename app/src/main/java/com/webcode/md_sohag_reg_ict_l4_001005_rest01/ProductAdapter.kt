package com.webcode.md_sohag_reg_ict_l4_001005_rest01

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.webcode.md_sohag_reg_ict_l4_001005_rest01.model.Product

class ProductAdapter(private val products: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int = products.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(product: Product) {
            // Bind data to views in the item layout
            itemView.findViewById<TextView>(R.id.txtProductName).text = product.title
            itemView.findViewById<TextView>(R.id.txtProductPrice).text = product.price.toString()
            Glide.with(itemView.context).load(product.images[0]).into(itemView.findViewById(R.id.imgProduct))
        }
    }
}
