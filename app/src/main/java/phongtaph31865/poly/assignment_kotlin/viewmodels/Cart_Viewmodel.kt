package phongtaph31865.poly.assignment_kotlin.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import phongtaph31865.poly.assignment_kotlin.api_service.Api_service
import phongtaph31865.poly.assignment_kotlin.models.Cart

class Cart_Viewmodel : ViewModel() {
    private val _apiService = Api_service
    val _cart: MutableState<List<Cart>> = mutableStateOf(emptyList())
    fun getCart() {
        viewModelScope.launch {
            try {
                _cart.value = _apiService.GET_CART()
            } catch (e: Exception) {
                println("Error: ${e.message}")
            }
        }
    }

    fun deleteItemCart(item: Cart) {
        _cart.value = _cart.value.filter { it != item }
        viewModelScope.launch {
            try {
                _apiService.DELETE_CART(item.id)
                Log.e("Cart", "Delete Success")
            } catch (e: Exception) {
                println("Error: ${e.message}")
            }
        }
    }

    fun checkOut() {
        viewModelScope.launch {
            try {
                for (item in _cart.value) {
                    val response = _apiService.POST_HISTORY(item)
                    if (response.isSuccessful) {
                        _cart.value = emptyList()
                        Log.e("Cart", "Check Out Success")
                    } else {
                        Log.e("Cart", "Check Out Failed")
                    }
                }
            } catch (e: Exception) {
                println("Cart: ${e.message}")
            }
        }
    }
}