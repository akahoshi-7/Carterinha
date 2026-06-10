package com.senai.carterinha.feature.home.presentation

sealed interface HomeEvent {
    data object OnCarteirinhaClick : HomeEvent
    data object OnUnidadesCurricularesClick : HomeEvent
}