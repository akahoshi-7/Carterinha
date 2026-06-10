package com.senai.carterinha.feature.carterinha.data.repository

import com.senai.carterinha.feature.carterinha.domain.model.Carteirinha
import kotlinx.coroutines.delay

class FakeCarteirinhaRepository : CarteirinhaRepository {
    override suspend fun buscarCarteirinha(): Result<Carteirinha> {
        delay(1500)

        return Result.success(
            Carteirinha(
                nome = "Akire",
                curso = "Técnico em Desenvolvimento de Sistemas",
                turma = "2Devest-B",
                matricula = "25162248",
                unidade = "SENAI Anchieta",
                status = "Ativo",
                qrCodeContent = "MATRICULA:25162248"
            )
        )
    }
}
