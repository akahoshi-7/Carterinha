package com.senai.carterinha.feature.auth.data.repository

import com.senai.carterinha.feature.auth.domain.model.UsuarioLogado
import kotlinx.coroutines.delay

class Auth {
    suspend fun login(login: String, senha: String): Result<UsuarioLogado> {
        delay(1500)

        return if (login == "aluno" && senha == "123") {
            Result.success(
                UsuarioLogado(
                    id = "1",
                    nome = "Akire"
                )
            )
        } else {
            Result.failure(IllegalArgumentException("Login ou senha inválidos. Use aluno / 123."))
        }
    }
}
