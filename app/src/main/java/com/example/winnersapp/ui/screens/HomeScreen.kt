package com.example.winnersapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.CorporateFare
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.HistoryEdu
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.SportsKabaddi
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.winnersapp.model.Screen
import com.example.winnersapp.ui.components.SectionSearchBar
import com.example.winnersapp.ui.theme.SportAccent
import com.example.winnersapp.ui.theme.SportRed

@Composable
fun HomeScreen(
    searchQuery: String,
    hasUnreadNews: Boolean,
    onQueryChange: (String) -> Unit,
    onNavigate: (Screen) -> Unit
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(scrollState)
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .testTag("home_screen"),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Buscador de secciones
        SectionSearchBar(
            query = searchQuery,
            onQueryChange = onQueryChange,
            onSectionSelected = onNavigate
        )

        // Hero Emblem
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(76.dp)
                    .rotate(3f)
                    .background(
                        brush = Brush.linearGradient(
                            listOf(SportRed, Color(0xFFEA580C))
                        ),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .border(2.dp, Color.White.copy(alpha = 0.25f), RoundedCornerShape(20.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "W",
                    color = Color.White,
                    fontWeight = FontWeight.Black,
                    fontSize = 38.sp
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "WINNERS FOR LIFE",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Black,
                fontStyle = FontStyle.Italic,
                letterSpacing = 1.sp,
                color = MaterialTheme.colorScheme.onBackground
            )

            Text(
                text = "Disciplina · Autocontrol · Respeto",
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.5.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        // Section Cards
        SectionCard(
            title = "Horarios de Clases",
            icon = Icons.Default.Schedule,
            iconTint = Color(0xFF4ADE80),
            iconBg = Color(0xFF22C55E).copy(alpha = 0.2f),
            testTag = "nav_horarios",
            onClick = { onNavigate(Screen.HORARIOS) }
        )

        SectionCard(
            title = "Noticias Oficiales",
            icon = Icons.Default.Newspaper,
            iconTint = SportAccent,
            iconBg = SportRed.copy(alpha = 0.2f),
            testTag = "nav_noticias",
            badgeText = if (hasUnreadNews) "NUEVO" else null,
            onClick = { onNavigate(Screen.NOTICIAS) }
        )

        SectionCard(
            title = "Exámenes de Cinto",
            icon = Icons.Default.School,
            iconTint = MaterialTheme.colorScheme.onSurface,
            iconBg = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
            testTag = "nav_examenes",
            onClick = { onNavigate(Screen.EXAMENES) }
        )

        SectionCard(
            title = "Fórmulas Tradicionales",
            icon = Icons.Default.SportsKabaddi,
            iconTint = Color(0xFF2DD4BF),
            iconBg = Color(0xFF14B8A6).copy(alpha = 0.2f),
            testTag = "nav_formulas",
            onClick = { onNavigate(Screen.FORMULAS) }
        )

        SectionCard(
            title = "Lección de Vida",
            icon = Icons.Default.Favorite,
            iconTint = Color(0xFFF472B6),
            iconBg = Color(0xFFEC4899).copy(alpha = 0.2f),
            testTag = "nav_leccion",
            onClick = { onNavigate(Screen.LECCION) }
        )

        SectionCard(
            title = "Torneos y Competencias",
            icon = Icons.Default.EmojiEvents,
            iconTint = Color(0xFFFACC15),
            iconBg = Color(0xFFEAB308).copy(alpha = 0.2f),
            testTag = "nav_torneos",
            onClick = { onNavigate(Screen.TORNEOS) }
        )

        SectionCard(
            title = "Juramentos ATA",
            icon = Icons.Default.HistoryEdu,
            iconTint = Color(0xFF60A5FA),
            iconBg = Color(0xFF3B82F6).copy(alpha = 0.2f),
            testTag = "nav_juramentos",
            onClick = { onNavigate(Screen.JURAMENTOS) }
        )

        SectionCard(
            title = "Lista de Precios",
            icon = Icons.Default.LocalOffer,
            iconTint = Color(0xFFFBBF24),
            iconBg = Color(0xFFF59E0B).copy(alpha = 0.2f),
            testTag = "nav_precios",
            onClick = { onNavigate(Screen.PRECIOS) }
        )

        SectionCard(
            title = "Nuestras Redes",
            icon = Icons.Default.Share,
            iconTint = Color(0xFFC084FC),
            iconBg = Color(0xFFA855F7).copy(alpha = 0.2f),
            testTag = "nav_redes",
            onClick = { onNavigate(Screen.REDES) }
        )

        SectionCard(
            title = "La Academia",
            icon = Icons.Default.CorporateFare,
            iconTint = SportRed,
            iconBg = SportRed.copy(alpha = 0.2f),
            testTag = "nav_academia",
            onClick = { onNavigate(Screen.ACADEMIA) }
        )

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
fun SectionCard(
    title: String,
    icon: ImageVector,
    iconTint: Color,
    iconBg: Color,
    testTag: String,
    badgeText: String? = null,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .testTag(testTag),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                Box(
                    modifier = Modifier
                        .size(46.dp)
                        .background(iconBg, RoundedCornerShape(14.dp))
                        .border(1.dp, iconTint.copy(alpha = 0.3f), RoundedCornerShape(14.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = iconTint,
                        modifier = Modifier.size(22.dp)
                    )
                    if (badgeText != null) {
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .align(Alignment.TopEnd)
                                .background(SportRed, CircleShape)
                        )
                    }
                }

                Spacer(modifier = Modifier.width(14.dp))

                Text(
                    text = title,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                if (badgeText != null) {
                    Text(
                        text = badgeText,
                        color = SportRed,
                        fontWeight = FontWeight.Black,
                        fontSize = 10.sp,
                        letterSpacing = 1.sp,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                }
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f),
                    modifier = Modifier.size(18.dp)
                )
            }
        }
    }
}
