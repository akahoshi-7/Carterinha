package com.senai.carterinha.feature.carterinha.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.senai.carterinha.R

@Composable
fun PerfilAluno(
    nome: String,
    curso: String,
    turma: String,
    matricula: String,
    unidade: String,
    status: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            space = 10.dp,
            alignment = Alignment.CenterVertically
        )
    ) {
        Image(
            painter = painterResource(R.drawable.angrybird),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth(.6f)
                .clip(CircleShape)
                .aspectRatio(1f)
        )
        InfoAluno(
            labelText = "Nome",
            valueText = nome,
            modifier = Modifier.fillMaxWidth()
        )
        InfoAluno(
            labelText = "Curso",
            valueText = curso,
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp,
            modifier = Modifier.fillMaxWidth()
        )
        InfoAluno(
            labelText = "Turma",
            valueText = turma,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            modifier = Modifier.fillMaxWidth()
        )
        InfoAluno(
            labelText = "Matrícula",
            valueText = matricula,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            modifier = Modifier.fillMaxWidth()
        )
        InfoAluno(
            labelText = "Unidade",
            valueText = unidade,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            modifier = Modifier.fillMaxWidth()
        )
        InfoAluno(
            labelText = "Status",
            valueText = status,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

