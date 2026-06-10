package com.senai.carterinha.feature.auth.data.repository

import com.senai.carterinha.feature.auth.domain.model.UsuarioLogado

interface AuthRepository {
    suspend fun login(login: String, senha: String): Result<UsuarioLogado>
}
