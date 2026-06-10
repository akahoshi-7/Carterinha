package com.senai.carterinha.core.designsystem.component

import android.icu.text.CaseMap
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch

@Composable
fun AppScaffold(
    title: String,
    subtitle: String? = null,
    usuarioNome: String,
    usuarioDescricao: String,
    drawerItems: List<AppDrawerItem>,
    onLogoutClick: () -> Unit,
    showBackButton: Boolean = false,
    onBackClick: (() -> Unit)? = null,
    content: @Composable (PaddingValues) -> Unit
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            AppDrawerContent(
                usuarioNome = usuarioNome,
                usuarioDescricao = usuarioDescricao,
                items = drawerItems.map { item ->
                    item.copy(
                        onClick = {
                            scope.launch { drawerState.close() }
                            item.onClick()
                        }
                    )
                },
                onLogoutClick = {
                    scope.launch { drawerState.close() }
                    onLogoutClick()
                }
            )
        }
    ) {
        Scaffold(
            topBar = {
                AppTopBar(
                    title = title,
                    subtitle = subtitle,
                    showBackButton = showBackButton,
                    onBackClick = onBackClick,
                    onMenuClick = { scope.launch { drawerState.open() } }
                )
            },
            content = content
        )
    }
}
