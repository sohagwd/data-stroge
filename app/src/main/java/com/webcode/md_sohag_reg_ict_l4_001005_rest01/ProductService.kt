package com.webcode.md_sohag_reg_ict_l4_001005_rest01

import com.webcode.md_sohag_reg_ict_l4_001005_rest01.model.Product
import retrofit2.http.GET

interface ProductService {
    @GET("products")
    suspend fun getProducts(): List<Product>
}