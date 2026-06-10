package com.senai.carterinha.feature.unidadecurricular.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.util.copy
import com.senai.carterinha.feature.unidadecurricular.data.repository.FakeUnidadeCurricularRepository
import com.senai.carterinha.feature.unidadecurricular.data.repository.UnidadeCurricularRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class UnidadeCurricularViewModel(
    private val repository: UnidadeCurricularRepository = FakeUnidadeCurricularRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow(UnidadeCurricularUiState())
    val uiState: StateFlow<UnidadeCurricularUiState> = _uiState.asStateFlow()

    init {
        carregarUnidadesCurriculares()
    }

    fun onEvent(event: UnidadeCurricularEvent) {
        when (event) {
            UnidadeCurricularEvent.OnCarregarDados,
            UnidadeCurricularEvent.OnTentarNovamenteClick -> carregarUnidadesCurriculares()
            UnidadeCurricularEvent.OnVoltarClick -> Unit
        }
    }

    private fun carregarUnidadesCurriculares() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isLoading = true,
                    errorMessage = null
                )
            }

            val result = repository.buscarUnidadesCurriculares()

            result
                .onSuccess { unidades ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            unidadesCurriculares = unidades,
                            errorMessage = null
                        )
                    }
                }
                .onFailure { throwable ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            errorMessage = throwable.message ?: "Erro ao carregar unidades curriculares."
                        )
                    }
                }
        }
    }
}