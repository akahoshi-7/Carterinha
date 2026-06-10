package com.senai.carterinha.core.designsystem.navigation

sealed class Routes(val route: String) {
    data object Login : Routes("login")
    data object Home : Routes("home")
    data object Carteirinha : Routes("carteirinha")
    data object UnidadesCurriculares : Routes("unidades_curriculares")
}
