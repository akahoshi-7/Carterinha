package com.senai.carterinha.feature.carterinha.data.repository

import com.senai.carterinha.feature.carterinha.domain.model.Carteirinha

interface CarteirinhaRepository {
    suspend fun buscarCarteirinha(): Result<Carteirinha>
}
