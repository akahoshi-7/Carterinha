package com.senai.carterinha.feature.carterinha.presentation.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.senai.carterinha.core.designsystem.component.AppDrawerItem
import com.senai.carterinha.core.designsystem.component.AppScaffold
import com.senai.carterinha.feature.carterinha.presentation.CarteirinhaEvent
import com.senai.carterinha.feature.carterinha.presentation.CarteirinhaViewModel

@Composable
fun CarteirinhaScreen(
    usuarioNome: String,
    usuarioDescricao: String,
    drawerItems: List<AppDrawerItem>,
    onLogoutClick: () -> Unit,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    viewModel: CarteirinhaViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    AppScaffold(
        title = "Carteirinha",
        subtitle = "Documento digital do aluno",
        usuarioNome = usuarioNome,
        usuarioDescricao = usuarioDescricao,
        drawerItems = drawerItems,
        onLogoutClick = onLogoutClick,
        showBackButton = true,
        onBackClick = onBackClick
    ) { innerPadding ->
        CarteirinhaContent(
            uiState = uiState,
            onEvent = { event ->
                when (event) {
                    CarteirinhaEvent.OnVoltarClick -> onBackClick()
                    else -> viewModel.onEvent(event)
                }
            },
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}
