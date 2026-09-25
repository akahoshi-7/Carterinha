package com.senai.carterinha.app.di

import com.senai.carterinha.core.auth.AuthTokenStore
import com.senai.carterinha.core.auth.InMemoryAuthTokenStore
import com.senai.carterinha.core.network.NetworkClient
import com.senai.carterinha.feature.login.data.remote.service.AuthApi
import com.senai.carterinha.feature.login.data.repository.ApiLoginRepositoryImpl
import com.senai.carterinha.feature.login.data.repository.FakeLoginRepositoryImpl
import com.senai.carterinha.feature.login.data.repository.LoginRepository
import com.senai.carterinha.feature.unidadecurriculares.data.remote.service.UnidadeCurricularApi
import com.senai.carterinha.feature.unidadecurriculares.data.repository.ApiUnidadeCurricularRepositoryImpl
import com.senai.carterinha.unidadecurriculares.domain.repository.UnidadeCurricularRepository

class DefaultAppContainer : AppContainer {

    override val authTokenStore: AuthTokenStore = InMemoryAuthTokenStore()
    private val publicNetworkClient = NetworkClient(baseUrl = BASE_URL )

    private val authenticatedNetworkClient = NetworkClient(
        baseUrl = BASE_URL,
        authTokenStore = authTokenStore
    )

    private val authApi: AuthApi by lazy {

        publicNetworkClient.create(AuthApi::class.java)
    }


    private val unidadeCurricularApi:UnidadeCurricularApi by lazy {

        authenticatedNetworkClient.create(UnidadeCurricularApi::class.java)
    }


    override val loginRepository:LoginRepository by lazy {

        if (USE_FAKE_LOGIN_REPOSITORY) {
            FakeLoginRepositoryImpl()

        } else {
            ApiLoginRepositoryImpl(api = authApi)
        }
    }


    override val unidadeCurricularRepository:UnidadeCurricularRepository by lazy {
        ApiUnidadeCurricularRepositoryImpl(api = unidadeCurricularApi)
    }


    companion object {
        private const val BASE_URL ="http://10.0.2.2:8080/"
        private const val USE_FAKE_LOGIN_REPOSITORY =false
    }
}