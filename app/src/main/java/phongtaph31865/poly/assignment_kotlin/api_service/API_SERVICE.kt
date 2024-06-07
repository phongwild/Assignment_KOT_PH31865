package phongtaph31865.poly.assignment_kotlin.api_service

import com.google.gson.GsonBuilder
import phongtaph31865.poly.assignment_kotlin.models.Category

import phongtaph31865.poly.assignment_kotlin.models.Product
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

var BASE_URL = "http://10.0.2.2:3000/"
var gson = GsonBuilder().create()
var Api_service = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create(gson))
    .build()
    .create<API_SERVICE>(API_SERVICE::class.java)
interface API_SERVICE {
    @GET("Product")
    suspend fun GET_PRODUCT(): List<Product>

    @GET("Category")
    suspend fun GET_CATEGORY(): List<Category>

}