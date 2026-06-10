package com.senai.carterinha.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.ExperimentalActivityApi
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalActivityApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App()
        }
    }
}


