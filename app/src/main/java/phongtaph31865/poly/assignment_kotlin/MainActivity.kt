package phongtaph31865.poly.assignment_kotlin
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import phongtaph31865.poly.assignment_kotlin.models.User
import phongtaph31865.poly.assignment_kotlin.ui.theme.Assignment_kotlinTheme
import phongtaph31865.poly.assignment_kotlin.viewmodels.User_Viewmodel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment_kotlinTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    MyApp()
                }
            }
        }
    }
    @Composable
    fun MyApp() {
        val navController = rememberNavController()
        AppNavHost(navController = navController)
    }
}

