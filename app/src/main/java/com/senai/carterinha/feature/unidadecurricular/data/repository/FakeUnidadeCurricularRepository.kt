package com.senai.carterinha.feature.unidadecurricular.data.repository

import com.senai.carterinha.core.designsystem.navigation.Routes
import com.senai.carterinha.feature.unidadecurricular.domain.model.UnidadeCurricular
import kotlinx.coroutines.delay
import kotlin.Result.Companion.success

class FakeUnidadeCurricularRepository : UnidadeCurricularRepository {
    override suspend fun buscarUnidadesCurriculares(): Result<List<UnidadeCurricular>> {
        delay(1800)

        return Result.success(
            listOf(
                UnidadeCurricular("1", "Programação Mobile", "Rafael Costa", 8.5, 9.0, 8.75, 2),
                UnidadeCurricular("2", "Backend", "Rafael Oliveira", 7.0, 8.0, 7.5, 4),
                UnidadeCurricular("3", "Teste de Agua", "Charlie", 9.0, 8.5, 8.75, 0),
                UnidadeCurricular("4", "Matematica", "Hatsune Miku", 8.0, 8.0, 8.0, 1),
                UnidadeCurricular("5", "Frontend", "Roger", 9.5, 9.0, 9.25, 0),
                UnidadeCurricular("6", "Guitarra", "Till", 7.5, 8.5, 8.0, 3),
                UnidadeCurricular("7", "Speedrun de comida", "Kasane Teto", 10.0, 9.5, 9.75, 0),
                UnidadeCurricular("8", "Corridade cavalo", "Agnis", 8.0, 7.5, 7.75, 2)
            )
        )
    }
}
