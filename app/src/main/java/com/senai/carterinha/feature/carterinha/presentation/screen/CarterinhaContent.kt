package com.senai.carterinha.feature.carterinha.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.senai.carterinha.R
import com.senai.carterinha.core.designsystem.theme.CarterinhaTheme
import com.senai.carterinha.feature.carterinha.domain.model.Carteirinha
import com.senai.carterinha.feature.carterinha.presentation.CarteirinhaEvent
import com.senai.carterinha.feature.carterinha.presentation.CarteirinhaUiState
import com.senai.carterinha.feature.carterinha.presentation.component.PerfilAluno
import com.senai.carterinha.feature.carterinha.presentation.component.QrCode
import com.senai.carterinha.feature.carterinha.presentation.screen.CarteirinhaContent
import com.senai.carterinha.feature.carterinha.presentation.screen.CarteirinhaContent as CarteirinhaContent1

@Composable
fun CarteirinhaContent(
    uiState: CarteirinhaUiState,
    onEvent: (CarteirinhaEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.am),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.7f)
        )

        when {
            uiState.isLoading -> {
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    CircularProgressIndicator()
                    Text("Buscando dados da carteirinha...")
                }
            }

            uiState.errorMessage != null -> {
                Column(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = uiState.errorMessage,
                        color = MaterialTheme.colorScheme.error
                    )
                    Button(onClick = { onEvent(CarteirinhaEvent.OnTentarNovamenteClick) }) {
                        Text("Tentar novamente")
                    }
                }
            }

            uiState.carteirinha != null -> {
                CarteirinhaDadosContent(
                    carteirinha = uiState.carteirinha,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Composable
private fun CarteirinhaDadosContent(
    carteirinha: Carteirinha,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .safeDrawingPadding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Image(
            painter = painterResource(R.drawable.senai),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(0.6f)
        )

        PerfilAluno(
            nome = carteirinha.nome,
            curso = carteirinha.curso,
            turma = carteirinha.turma,
            matricula = carteirinha.matricula,
            unidade = carteirinha.unidade,
            status = carteirinha.status,
            modifier = Modifier.fillMaxWidth(0.9f)
        )

        QrCode(
            conteudo = carteirinha.qrCodeContent,
            modifier = Modifier.fillMaxWidth(0.6f)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CarteirinhaContentPreviewClaro() {
    CarterinhaTheme(darkTheme = false) {
        CarteirinhaContent(
             uiState = CarteirinhaUiState(
                 carteirinha = Carteirinha(
                     nome = "Rafael Costa",
                     curso = "Técnico em Desenvolvimento de Sistemas",
                     turma = "4DEVM-T1",
                     matricula = "20260001",
                     unidade = "SENAI Anchieta",
                     status = "Ativo",
                     qrCodeContent = "20260001"
                 )
             ),
             onEvent = {}
         )
    }
}

