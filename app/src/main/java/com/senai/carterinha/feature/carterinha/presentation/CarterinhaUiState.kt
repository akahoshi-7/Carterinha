package com.senai.carterinha.feature.carterinha.presentation

import com.senai.carterinha.feature.carterinha.domain.model.Carteirinha

data class CarteirinhaUiState(
    val isLoading: Boolean = false,
    val carteirinha: Carteirinha? = null,
    val errorMessage: String? = null
)