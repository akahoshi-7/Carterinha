package com.senai.carterinha.feature.login.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavController = NavController(
        LocalContext.current
    ),
    viewModel: LoginViewModel = viewModel(),
    onLoginSucesso:(UsuarioLogado)-> Unit = {}
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(uiState.usuarioLogado) {
        uiState.usuarioLogado?.let{
                usuario ->
            viewModel.onEvent(LoginEvent.OnNavegacaoRealizada)
            onLoginSucesso(usuario)
        }
    }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement
            .spacedBy(10.dp, Alignment.CenterVertically),
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = "Login",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        TextField(
            value = uiState.usuario,
            onValueChange = { value ->
                viewModel.onEvent(LoginEvent.OnUsuarioChange(value))
            },
            label = {
                Text(
                    text = "Email"
                )
            },
            isError = uiState.erroMessage != null
        )
        OutlinedTextField(
            value = uiState.senha,
            onValueChange = { value ->
                viewModel.onEvent(LoginEvent.OnSenhaChange(value))
            },
            label = {
                Text(
                    text = "Senha"
                )
            },
            isError = uiState.erroMessage != null
        )

        uiState.erroMessage?.let{ error ->
            Text(
                text = error,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.fillMaxWidth(0.85f)
            )
        }

        Button(
            onClick = {
                viewModel.onEvent(LoginEvent.OnEntrarClick)
            },
            shape = RoundedCornerShape(size = 4.dp),
            border = BorderStroke(
                width = 2.dp,
                color = Color.Black
            ),
            colors = ButtonDefaults.buttonColors(
                contentColor = MaterialTheme.colorScheme.secondary
            ),
            modifier = Modifier
                .fillMaxWidth(.6f)
        ) {
            if (uiState.isLoading){
                LinearProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth(0.60f)
                        .height(5.dp),
                    color = Color.White,
                    trackColor = Color.White.copy(alpha = 0.35f)
                )
            }else {
                Text(
                    text = "Entrar",
                    color = Color.White
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}