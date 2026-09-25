package com.senai.carterinha.app

import android.app.Application
import com.senai.carterinha.app.di.AppContainer
import com.senai.carterinha.app.di.DefaultAppContainer





class CarteirinhaApplication : Application() {
    val container: AppContainer by lazy {
        DefaultAppContainer()
    }
}