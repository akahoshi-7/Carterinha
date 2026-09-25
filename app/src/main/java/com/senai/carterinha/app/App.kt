package com.senai.carterinha.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.senai.carterinha.app.di.AppContainer
import com.senai.carterinha.app.navigation.AppNavHost
import com.senai.carterinha.core.designsystem.theme.CarterinhaTheme

@Composable
fun App(container: AppContainer) {
    CarterinhaTheme() {
        val navController = rememberNavController()
        AppNavHost(
            navController = navController,
        )
    }
}