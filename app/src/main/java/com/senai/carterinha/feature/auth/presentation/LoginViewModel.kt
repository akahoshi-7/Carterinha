package com.senai.carterinha.feature.auth.presentation
import com.senai.carterinha.feature.auth.data.repository.Auth
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class LoginViewModel(
    private val repository: Auth = Auth()
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.OnLoginChange -> {
                _uiState.update { state ->
                    state.copy(login = event.value)
                }
            }

            is LoginEvent.OnSenhaChange -> {
                _uiState.update { state ->
                    state.copy(senha = event.value)
                }
            }

            LoginEvent.OnEntrarClick -> fazerLogin()

            LoginEvent.OnNavegacaoRealizada -> {
                _uiState.update { state ->
                    state.copy(usuarioLogado = null)
                }
            }
        }
    }

    private fun fazerLogin() {
        val state = _uiState.value

        if (state.login.isBlank() || state.senha.isBlank()) {
            return
        }

        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isLoading = true,
                    usuarioLogado = null
                )
            }

            val result = repository.login(
                state.login.trim(),
                state.senha
            )

            result.onSuccess { usuario ->
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        usuarioLogado = usuario
                    )
                }
            }
        }
    }
}