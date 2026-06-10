package com.senai.carterinha.feature.home.presentation.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.senai.carterinha.core.designsystem.component.AppDrawerItem
import com.senai.carterinha.core.designsystem.component.AppScaffold
import com.senai.carterinha.feature.home.presentation.HomeEvent
import com.senai.carterinha.feature.home.presentation.HomeViewModel

@Composable
fun HomeScreen(
    usuarioNome: String,
    usuarioDescricao: String,
    drawerItems: List<AppDrawerItem>,
    onLogoutClick: () -> Unit,
    modifier: Modifier = Modifier,
    onCarteirinhaClick: () -> Unit,
    onUnidadesCurricularesClick: () -> Unit,
    viewModel: HomeViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    AppScaffold(
        title = "Início",
        subtitle = "Área do aluno",
        usuarioNome = usuarioNome,
        usuarioDescricao = usuarioDescricao,
        drawerItems = drawerItems,
        onLogoutClick = onLogoutClick
    ) { innerPadding ->
        HomeContent(
            uiState = uiState.copy(nomeAluno = usuarioNome),
            onEvent = { event ->
                viewModel.onEvent(event)
                when (event) {
                    HomeEvent.OnCarteirinhaClick -> onCarteirinhaClick()
                    HomeEvent.OnUnidadesCurricularesClick -> onUnidadesCurricularesClick()
                }
            },
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}
