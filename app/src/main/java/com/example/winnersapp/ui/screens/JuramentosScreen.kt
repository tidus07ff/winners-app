package com.example.winnersapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.HistoryEdu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.winnersapp.ui.components.ScreenHeader

@Composable
fun JuramentosScreen(
    onBack: () -> Unit
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(scrollState)
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .testTag("juramentos_screen")
    ) {
        ScreenHeader(
            title = "Juramentos ATA",
            accentColor = Color(0xFF3B82F6),
            onBack = onBack
        )

        OathCard(
            category = "Tigers",
            ageRange = "4 a 6 años",
            oathText = "Señor! Para ser una buena persona necesito: conocimiento en la mente, honestidad en mi corazón, fuerza en los músculos, hacer muchos amigos y así ser un cinturón negro.",
            badgeColor = Color(0xFFF97316)
        )

        Spacer(modifier = Modifier.height(14.dp))

        OathCard(
            category = "Juniors",
            ageRange = "7 a 12 años",
            oathText = "Señor! Viviré cada día honrando a mis padres e instructores, practicando mis mejores habilidades, con cortesía y respeto hacia todas las personas, señor!",
            badgeColor = Color(0xFF3B82F6)
        )

        Spacer(modifier = Modifier.height(14.dp))

        OathCard(
            category = "Jóvenes y Adultos",
            ageRange = "13+ años",
            oathText = "Señor! Viviré con perseverancia en el espíritu del Taekwondo, en honor con los demás, integridad conmigo mismo y autocontrol de mis acciones, señor!",
            badgeColor = Color(0xFFE60000)
        )

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
fun OathCard(
    category: String,
    ageRange: String,
    oathText: String,
    badgeColor: Color
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .background(badgeColor.copy(alpha = 0.15f), RoundedCornerShape(10.dp))
                        .border(1.dp, badgeColor.copy(alpha = 0.3f), RoundedCornerShape(10.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.HistoryEdu,
                        contentDescription = null,
                        tint = badgeColor,
                        modifier = Modifier.size(18.dp)
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))

                Column {
                    Text(
                        text = "Juramento $category",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = ageRange,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
                        RoundedCornerShape(12.dp)
                    )
                    .padding(14.dp)
            ) {
                Text(
                    text = "\"$oathText\"",
                    style = MaterialTheme.typography.bodyMedium,
                    fontStyle = FontStyle.Italic,
                    color = MaterialTheme.colorScheme.onSurface,
                    lineHeight = 22.sp
                )
            }
        }
    }
}
