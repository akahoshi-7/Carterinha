package com.senai.carterinha.feature.auth.domain.model

data class UsuarioLogado(
    val id: String,
    val nome: String,
    val token: String
)
