package com.senai.carterinha.feature.login.data.repository

interface LoginRepository {
    suspend fun login( usuario:String, senha:String): Result<UsuarioLogado>
}