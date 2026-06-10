package com.senai.carterinha.feature.auth.presentation.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.senai.carterinha.core.designsystem.theme.CarterinhaTheme
import com.senai.carterinha.feature.auth.presentation.LoginEvent
import com.senai.carterinha.feature.auth.presentation.LoginUiState

@Composable
fun LoginContent(
    uiState: LoginUiState,
    onEvent: (LoginEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            space = 16.dp,
            alignment = Alignment.CenterVertically
        )
    ) {
        Text(
            text = "Carteirinha Digital",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground
        )

        OutlinedTextField(
            value = uiState.login,
            onValueChange = { value ->
                onEvent(LoginEvent.OnLoginChange(value))
            },
            label = { Text("Login") },
            singleLine = true,
            enabled = !uiState.isLoading,
            modifier = Modifier.fillMaxWidth(0.85f)
        )

        OutlinedTextField(
            value = uiState.senha,
            onValueChange = { value ->
                onEvent(LoginEvent.OnSenhaChange(value))
            },
            label = { Text("Senha") },
            singleLine = true,
            enabled = !uiState.isLoading,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            modifier = Modifier.fillMaxWidth(0.85f)
        )

        uiState.errorMessage?.let { message ->
            Text(
                text = message,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.fillMaxWidth(0.85f)
            )
        }

        Button(
            onClick = {
                onEvent(LoginEvent.OnEntrarClick)
            },
            enabled = !uiState.isLoading,
            modifier = Modifier.fillMaxWidth(0.6f),
            shape = RoundedCornerShape(size = 9.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.background
            ),
            border = BorderStroke(
                2.dp,
                MaterialTheme.colorScheme.primary
            )
        ) {
            if (uiState.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.fillMaxWidth(0.12f),
                    strokeWidth = 2.dp
                )
            } else {
                Text("Entrar")
            }
        }

        Text(
            text = "Teste: aluno / 123",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewLoginContentClaro() {
    CarterinhaTheme(darkTheme = false) {
        LoginContent(
            uiState = LoginUiState(),
            onEvent = {}
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewLoginContentEscuro() {
    CarterinhaTheme(darkTheme = true) {
        LoginContent(
            uiState = LoginUiState(),
            onEvent = {}
        )
    }
}
