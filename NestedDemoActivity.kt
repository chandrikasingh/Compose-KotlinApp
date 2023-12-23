package com.demo.nfca

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.demo.nfca.ui.theme.NesedFlowComposeAppTheme

class NestedDemoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NesedFlowComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    nestedNavControlFlow()
                }
            }
        }
    }

    @Composable
    private fun nestedNavControlFlow() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = ScreenNavGraph.AuthRoute.route) {

            composable(route = ScreenNavGraph.Splash.route) {
                SplashScreen(navController = navController)
            }
            authGraph(navController)
            appGraph(navController)
        }
    }

}



/*  navigation(startDestination = NavScreenGraph.Login.route, route = NavScreenGraph.AuthRoute.route ){
      composable(route = NavScreenGraph.Login.route) {
          LoginAccountScreen(navController = navController)
      }

      composable(route = NavScreenGraph.Register.route) {
          RegisterAccountScreen(navController = navController)
      }

      composable(route = NavScreenGraph.Forget.route) {
          ForgetPwdScreen(navController = navController)
      }
  }

   ///////////////////////////////
  navigation(startDestination = NavScreenGraph.HomeScreen.route, route = NavScreenGraph.AppRoute.route ){
       composable(route = NavScreenGraph.HomeScreen.route) {
           HomeScreen(navController = navController)
       }
       composable(route = NavScreenGraph.AScreen.route) {
           ANavScreen(navController = navController)
       }
       composable(route = NavScreenGraph.BScreen.route) {
           ANavScreen(navController = navController)
       }
   }
   */