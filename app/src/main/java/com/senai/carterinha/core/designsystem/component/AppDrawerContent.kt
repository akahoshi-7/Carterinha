package com.senai.carterinha.core.designsystem.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.Navigation

@Composable
fun AppDrawerContent(
    usuarioNome: String,
    usuarioDescricao: String,
    items: List<AppDrawerItem>,
    onLogoutClick: () -> Unit,
    modifier : Modifier = Modifier
){
    ModalDrawerSheet(modifier = modifier.fillMaxHeight()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = usuarioNome,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                text = usuarioDescricao,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Divider()
        Spacer(modifier = Modifier.height(8.dp))

        items.forEach { item ->
            NavigationDrawerItem(
                label = { Text(item.label) },
                selected = item.selected,
                icon = { Icon(item.icon, contentDescription = null) },
                onClick = item.onClick,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
            )
        }

        Spacer(modifier = Modifier.weight(1f))
        Divider()

        NavigationDrawerItem(
            label = { Text("Sair") },
            selected = false,
            icon = { Icon(Icons.Default.Logout, contentDescription = null) },
            onClick = onLogoutClick,
            modifier = Modifier.padding(12.dp)
        )
    }
}