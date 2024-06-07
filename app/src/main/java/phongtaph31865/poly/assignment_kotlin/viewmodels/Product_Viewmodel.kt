package phongtaph31865.poly.assignment_kotlin.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import phongtaph31865.poly.assignment_kotlin.api_service.Api_service
import phongtaph31865.poly.assignment_kotlin.models.Product

class Product_Viewmodel: ViewModel() {
    private val apiService = Api_service
    val products: MutableState<List<Product>> = mutableStateOf(emptyList())
    fun get_products() {
        viewModelScope.launch {
            try {
                val response = apiService.GET_PRODUCT()
                products.value = response
                Log.e("list_product", "success")
            } catch (e: Exception) {
                Log.e("list_product", e.message.toString())
            }
        }
    }
}