package com.senai.carterinha.feature.unidadecurricular.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.senai.carterinha.core.designsystem.theme.CarterinhaTheme
import com.senai.carterinha.feature.unidadecurricular.domain.model.UnidadeCurricular

@Composable
fun UnidadeCurricularCard(
    unidadeCurricular: UnidadeCurricular,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = unidadeCurricular.nome,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Professor: ${unidadeCurricular.professor}",
                style = MaterialTheme.typography.bodyMedium
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("N1: ${unidadeCurricular.nota1}")
                Text("N2: ${unidadeCurricular.nota2}")
                Text("Média: ${unidadeCurricular.media}")
            }

            Text(
                text = "Faltas: ${unidadeCurricular.faltas}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UnidadeCurricularCardPreview() {
    CarterinhaTheme{
        UnidadeCurricularCard(
            unidadeCurricular = UnidadeCurricular(
                id = "1",
                nome = "Programação Mobile",
                professor = "Rafael Costa",
                nota1 = 8.5,
                nota2 = 9.0,
                media = 8.75,
                faltas = 2
            )
        )
    }
}
