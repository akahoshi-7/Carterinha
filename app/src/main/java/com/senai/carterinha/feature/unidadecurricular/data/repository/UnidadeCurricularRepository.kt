package com.senai.carterinha.feature.unidadecurricular.data.repository

import com.senai.carterinha.core.designsystem.navigation.Routes
import com.senai.carterinha.feature.unidadecurricular.domain.model.UnidadeCurricular

interface UnidadeCurricularRepository {

    suspend fun buscarUnidadesCurriculares(): Result<List<UnidadeCurricular>>

}
