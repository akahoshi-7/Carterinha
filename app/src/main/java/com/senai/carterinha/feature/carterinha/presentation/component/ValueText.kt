package com.senai.carterinha.feature.carterinha.presentation.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit

@Composable
fun ValueText(
    value: String,
    fontSize: TextUnit = MaterialTheme.typography.titleLarge.fontSize,
    fontWeight: FontWeight = MaterialTheme.typography.titleLarge.fontWeight ?: FontWeight.Normal,
    modifier: Modifier = Modifier
) {
    Text(
        text = value,
        fontSize = fontSize,
        fontWeight = fontWeight,
        fontFamily = MaterialTheme.typography.titleLarge.fontFamily,
        lineHeight = MaterialTheme.typography.titleLarge.lineHeight,
        modifier = modifier,
        softWrap = true,
        color = MaterialTheme.colorScheme.onSurface
    )
}