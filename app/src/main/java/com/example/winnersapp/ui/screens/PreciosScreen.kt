package com.example.winnersapp.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.winnersapp.data.DataProvider
import com.example.winnersapp.ui.components.ScreenHeader
import com.example.winnersapp.ui.theme.SportRed
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PreciosScreen(
    searchQuery: String,
    expandedId: String?,
    studentName: String,
    studentAge: String,
    studentHeight: String,
    studentAcademy: String,
    onSearchChange: (String) -> Unit,
    onToggleItem: (String) -> Unit,
    onUpdateForm: (String, String, String, String) -> Unit,
    onBack: () -> Unit
) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    val filteredItems = DataProvider.prices.filter { item ->
        searchQuery.isBlank() ||
                item.name.lowercase().contains(searchQuery.lowercase()) ||
                item.category.lowercase().contains(searchQuery.lowercase()) ||
                item.keywords.lowercase().contains(searchQuery.lowercase())
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(scrollState)
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .testTag("precios_screen")
    ) {
        ScreenHeader(
            title = "Lista de Precios",
            accentColor = Color(0xFFF59E0B),
            onBack = onBack
        )

        // Buscador
        OutlinedTextField(
            value = searchQuery,
            onValueChange = onSearchChange,
            placeholder = { Text("Buscar objeto...", fontSize = 13.sp) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.size(18.dp)
                )
            },
            trailingIcon = {
                if (searchQuery.isNotEmpty()) {
                    IconButton(onClick = { onSearchChange("") }) {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = "Limpiar",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            },
            singleLine = true,
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .testTag("precios_search_input")
        )

        Spacer(modifier = Modifier.height(14.dp))

        filteredItems.forEach { item ->
            val isExpanded = expandedId == item.id

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
                    .testTag("price_item_${item.id}"),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onToggleItem(item.id) },
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.weight(1f)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .background(
                                        Color(0xFFF59E0B).copy(alpha = 0.15f),
                                        RoundedCornerShape(10.dp)
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.LocalOffer,
                                    contentDescription = null,
                                    tint = Color(0xFFF59E0B),
                                    modifier = Modifier.size(18.dp)
                                )
                            }

                            Spacer(modifier = Modifier.width(12.dp))

                            Column {
                                Text(
                                    text = item.name,
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = item.category,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = item.priceText,
                                fontWeight = FontWeight.Black,
                                fontSize = 16.sp,
                                color = Color(0xFF22C55E)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Icon(
                                imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }

                    // Formulario expandido para solicitar por WhatsApp
                    AnimatedVisibility(visible = isExpanded) {
                        var academyExpanded by remember { mutableStateOf(false) }

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 14.dp)
                                .background(
                                    MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
                                    RoundedCornerShape(12.dp)
                                )
                                .padding(12.dp)
                        ) {
                            Text(
                                text = "Completar datos para solicitar por WhatsApp:",
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            OutlinedTextField(
                                value = studentName,
                                onValueChange = { onUpdateForm(it, studentAge, studentHeight, studentAcademy) },
                                label = { Text("Nombre y apellido del estudiante", fontSize = 11.sp) },
                                singleLine = true,
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.fillMaxWidth()
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Row(modifier = Modifier.fillMaxWidth()) {
                                OutlinedTextField(
                                    value = studentAge,
                                    onValueChange = { onUpdateForm(studentName, it, studentHeight, studentAcademy) },
                                    label = { Text("Edad", fontSize = 11.sp) },
                                    singleLine = true,
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                    shape = RoundedCornerShape(8.dp),
                                    modifier = Modifier.weight(1f)
                                )

                                Spacer(modifier = Modifier.width(8.dp))

                                OutlinedTextField(
                                    value = studentHeight,
                                    onValueChange = { onUpdateForm(studentName, studentAge, it, studentAcademy) },
                                    label = { Text("Altura (cm)", fontSize = 11.sp) },
                                    singleLine = true,
                                    shape = RoundedCornerShape(8.dp),
                                    modifier = Modifier.weight(1f)
                                )
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            ExposedDropdownMenuBox(
                                expanded = academyExpanded,
                                onExpandedChange = { academyExpanded = !academyExpanded }
                            ) {
                                OutlinedTextField(
                                    value = studentAcademy,
                                    onValueChange = {},
                                    readOnly = true,
                                    label = { Text("Academia", fontSize = 11.sp) },
                                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = academyExpanded) },
                                    shape = RoundedCornerShape(8.dp),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .menuAnchor(MenuAnchorType.PrimaryNotEditable)
                                )
                                ExposedDropdownMenu(
                                    expanded = academyExpanded,
                                    onDismissRequest = { academyExpanded = false }
                                ) {
                                    DropdownMenuItem(
                                        text = { Text("Winners Pocitos") },
                                        onClick = {
                                            onUpdateForm(studentName, studentAge, studentHeight, "Winners Pocitos")
                                            academyExpanded = false
                                        }
                                    )
                                    DropdownMenuItem(
                                        text = { Text("Winners BZO") },
                                        onClick = {
                                            onUpdateForm(studentName, studentAge, studentHeight, "Winners BZO")
                                            academyExpanded = false
                                        }
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(12.dp))

                            Button(
                                onClick = {
                                    val msg = "Saludos! me gustaria adquirir ${item.name}.\n" +
                                            "Nombre y apellido del estudiante: ${studentName.trim()}\n" +
                                            "Edad del estudiante: ${studentAge.trim()}\n" +
                                            "Altura del estudiante: ${studentHeight.trim()}\n" +
                                            "Academia: ${studentAcademy.trim()}"
                                    val encoded = URLEncoder.encode(msg, StandardCharsets.UTF_8.toString())
                                    val url = "https://wa.me/59891809219?text=$encoded"
                                    try {
                                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                                        context.startActivity(intent)
                                    } catch (e: Exception) {
                                        // Ignore
                                    }
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF22C55E)),
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .testTag("btn_request_${item.id}")
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Send,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "Solicitar objeto por WhatsApp",
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    fontSize = 13.sp
                                )
                            }
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}
