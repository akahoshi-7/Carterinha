package com.senai.carterinha.feature.unidadecurricular.presentation.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.senai.carterinha.core.designsystem.component.AppDrawerItem
import com.senai.carterinha.core.designsystem.component.AppScaffold
import com.senai.carterinha.feature.unidadecurricular.presentation.UnidadeCurricularEvent
import com.senai.carterinha.feature.unidadecurricular.presentation.UnidadeCurricularViewModel

@Composable
fun UnidadeCurricularScreen(
    usuarioNome: String,
    usuarioDescricao: String,
    drawerItems: List<AppDrawerItem>,
    onLogoutClick: () -> Unit,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    viewModel: UnidadeCurricularViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    AppScaffold(
        title = "Unidades Curriculares",
        subtitle = "Notas, médias e faltas",
        usuarioNome = usuarioNome,
        usuarioDescricao = usuarioDescricao,
        drawerItems = drawerItems,
        onLogoutClick = onLogoutClick,
        showBackButton = true,
        onBackClick = onBackClick
    ) { innerPadding ->
        UnidadeCurricularContent(
            uiState = uiState,
            onEvent = { event ->
                when (event) {
                    UnidadeCurricularEvent.OnVoltarClick -> onBackClick()
                    else -> viewModel.onEvent(event)
                }
            },
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}
