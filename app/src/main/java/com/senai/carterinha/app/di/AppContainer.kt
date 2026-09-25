package com.senai.carterinha.app.di

import com.senai.carterinha.core.auth.AuthTokenStore
import com.senai.carterinha.feature.login.data.repository.LoginRepository
import com.senai.carterinha.feature.unidadecurriculares.domain.repository.UnidadeCurricularRepository

interface AppContainer {

    val loginRepository: LoginRepository

    val unidadeCurricularRepository: UnidadeCurricularRepository

    val authTokenStore: AuthTokenStore
}