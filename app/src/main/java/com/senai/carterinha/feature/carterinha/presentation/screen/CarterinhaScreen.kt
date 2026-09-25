package com.senai.carterinha.feature.carterinha.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.senai.carterinha.feature.carterinha.presentation.component.PerfilAluno


@Composable
fun CarteirinhaScreen(
    modifier: Modifier = Modifier
) {
    Box {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
            modifier = modifier.fillMaxSize()

        ) {
            PerfilAluno(
                nome = "Kaikai",
                curso = "Desenvolvimento de Sistemas"
            )
        }

    }

}