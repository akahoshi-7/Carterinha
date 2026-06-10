package com.senai.carterinha.core.designsystem.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.senai.carterinha.core.designsystem.component.AppDrawerItem
import com.senai.carterinha.core.session.LoggedUser
import com.senai.carterinha.feature.auth.presentation.screen.LoginScreen
import com.senai.carterinha.feature.carterinha.presentation.screen.CarteirinhaScreen
import com.senai.carterinha.feature.home.presentation.screen.HomeScreen
import com.senai.carterinha.feature.unidadecurricular.presentation.screen.UnidadeCurricularScreen

@Composable
fun AppNavHost(
    navController: NavHostController
) {
    var loggedUser by remember { mutableStateOf<LoggedUser?>(null) }
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    fun navigateTo(route: String) {
        navController.navigate(route) {
            launchSingleTop = true
            popUpTo(Routes.Home.route) {
                inclusive = false
            }
        }
    }

    fun logout() {
        loggedUser = null
        navController.navigate(Routes.Login.route) {
            popUpTo(0) { inclusive = true }
            launchSingleTop = true
        }
    }

    fun drawerItems(): List<AppDrawerItem> = listOf(
        AppDrawerItem(
            label = "Início",
            icon = Icons.Default.Home,
            selected = currentRoute == Routes.Home.route,
            onClick = { navigateTo(Routes.Home.route) }
        ),
        AppDrawerItem(
            label = "Carteirinha",
            icon = Icons.Default.Badge,
            selected = currentRoute == Routes.Carteirinha.route,
            onClick = { navigateTo(Routes.Carteirinha.route) }
        ),
        AppDrawerItem(
            label = "Unidades Curriculares",
            icon = Icons.Default.MenuBook,
            selected = currentRoute == Routes.UnidadesCurriculares.route,
            onClick = { navigateTo(Routes.UnidadesCurriculares.route) }
        )
    )

    @Composable
    fun authenticatedUserContent(content: @Composable (LoggedUser) -> Unit) {
        val user = loggedUser
        if (user == null) {
            navController.navigate(Routes.Login.route) {
                popUpTo(0) { inclusive = true }
                launchSingleTop = true
            }
        } else {
            content(user)
        }
    }

    NavHost(
        navController = navController,
        startDestination = Routes.Login.route
    ) {
        composable(Routes.Login.route) {
            LoginScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                onLoginSuccess = { usuario ->
                    loggedUser = LoggedUser(
                        id = usuario.id,
                        nome = usuario.nome,
                        token = usuario.token
                    )
                    navController.navigate(Routes.Home.route) {
                        popUpTo(Routes.Login.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(Routes.Home.route) {
            authenticatedUserContent { user ->
                HomeScreen(
                    usuarioNome = user.nome,
                    usuarioDescricao = user.descricao,
                    drawerItems = drawerItems(),
                    onLogoutClick = { logout() },
                    modifier = Modifier.fillMaxSize(),
                    onCarteirinhaClick = {
                        navController.navigate(Routes.Carteirinha.route)
                    },
                    onUnidadesCurricularesClick = {
                        navController.navigate(Routes.UnidadesCurriculares.route)
                    }
                )
            }
        }

        composable(Routes.Carteirinha.route) {
            authenticatedUserContent { user ->
                CarteirinhaScreen(
                    usuarioNome = user.nome,
                    usuarioDescricao = user.descricao,
                    drawerItems = drawerItems(),
                    onLogoutClick = { logout() },
                    modifier = Modifier.fillMaxSize(),
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }
        }

        composable(Routes.UnidadesCurriculares.route) {
            authenticatedUserContent { user ->
                UnidadeCurricularScreen(
                    usuarioNome = user.nome,
                    usuarioDescricao = user.descricao,
                    drawerItems = drawerItems(),
                    onLogoutClick = { logout() },
                    modifier = Modifier.fillMaxSize(),
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}
