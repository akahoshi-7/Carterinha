package com.senai.carterinha.feature.carterinha.presentation

sealed interface CarteirinhaEvent {
    data object OnCarregarDados : CarteirinhaEvent
    data object OnTentarNovamenteClick : CarteirinhaEvent
    data object OnVoltarClick : CarteirinhaEvent
}