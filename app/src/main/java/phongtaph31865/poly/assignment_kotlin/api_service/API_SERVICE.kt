package phongtaph31865.poly.assignment_kotlin.api_service

import com.google.gson.GsonBuilder
import phongtaph31865.poly.assignment_kotlin.models.Cart
import phongtaph31865.poly.assignment_kotlin.models.Category
import phongtaph31865.poly.assignment_kotlin.models.Favorite

import phongtaph31865.poly.assignment_kotlin.models.Product
import phongtaph31865.poly.assignment_kotlin.models.User
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

var BASE_URL = "http://10.0.2.2:3000/"
var gson = GsonBuilder().create()
var Api_service = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create(gson))
    .build()
    .create<API_SERVICE>(API_SERVICE::class.java)
interface API_SERVICE {
    //Product
    @GET("Product")
    suspend fun GET_PRODUCT(): List<Product>
    @GET("Category")
    suspend fun GET_CATEGORY(): List<Category>

    @POST("Cart")
    suspend fun POST_CART(@Body product: Product): Response<Unit>
    @POST("Cart")
    suspend fun POST_CART_IN_FAV(@Body favorite: Favorite): Response<Unit>
    @GET("Cart")
    suspend fun GET_CART(): List<Cart>
    @DELETE("Cart/{id}")
    suspend fun DELETE_CART(@Path("id") id: String): Response<Unit>

    @POST("History")
    suspend fun POST_HISTORY(@Body cart: Cart): Response<Unit>

    @POST("User")
    suspend fun REGISTER(@Body user: User): Response<Unit>
    @GET("User")
    suspend fun GET_USER(): List<User>

    @POST("Favorite")
    suspend fun POST_FAVORITE(@Body product: Product): Response<Unit>
    @GET("Favorite")
    suspend fun GET_FAVORITE(): List<Favorite>
    @DELETE("Favorite/{id}")
    suspend fun DELETE_FAVORITE(@Path("id") id: String): Response<Unit>

}