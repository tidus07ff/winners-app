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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Schedule
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.winnersapp.ui.components.ScreenHeader
import com.example.winnersapp.ui.theme.SportRed

@Composable
fun HorariosScreen(
    selectedAcademy: String,
    onSelectAcademy: (String) -> Unit,
    onBack: () -> Unit
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(scrollState)
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .testTag("horarios_screen")
    ) {
        ScreenHeader(
            title = "Horarios de Clases",
            accentColor = Color(0xFF22C55E),
            onBack = onBack
        )

        // Academy selector tab
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = MaterialTheme.colorScheme.surfaceVariant,
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(4.dp)
        ) {
            val isPocitos = selectedAcademy == "pocitos"
            Box(
                modifier = Modifier
                    .weight(1f)
                    .background(
                        color = if (isPocitos) SportRed else Color.Transparent,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .clickable { onSelectAcademy("pocitos") }
                    .padding(vertical = 10.dp)
                    .testTag("tab_pocitos"),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Winners Pocitos",
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    color = if (isPocitos) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            val isBrazo = selectedAcademy == "brazo"
            Box(
                modifier = Modifier
                    .weight(1f)
                    .background(
                        color = if (isBrazo) SportRed else Color.Transparent,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .clickable { onSelectAcademy("brazo") }
                    .padding(vertical = 10.dp)
                    .testTag("tab_brazo"),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Brazo Oriental",
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    color = if (isBrazo) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (selectedAcademy == "pocitos") {
            // Sede Pocitos
            ClassScheduleCard(
                category = "Tigers",
                ageGroup = "4 a 6 años",
                sessions = listOf(
                    "Lunes y Miércoles: 18:15 hs",
                    "Martes y Jueves: 18:00 hs"
                ),
                color = Color(0xFFF97316)
            )

            Spacer(modifier = Modifier.height(10.dp))

            ClassScheduleCard(
                category = "Juniors",
                ageGroup = "7 a 12 años",
                sessions = listOf(
                    "Lunes y Miércoles: 17:30 hs",
                    "Lunes a Jueves: 19:00 hs",
                    "Viernes: 18:30 hs"
                ),
                color = Color(0xFF3B82F6)
            )

            Spacer(modifier = Modifier.height(10.dp))

            ClassScheduleCard(
                category = "Pre Adolescentes",
                ageGroup = "13 a 15 años",
                sessions = listOf(
                    "Lunes a Jueves: 19:45 hs",
                    "Viernes: 20:00 hs"
                ),
                color = Color(0xFFA855F7)
            )

            Spacer(modifier = Modifier.height(10.dp))

            ClassScheduleCard(
                category = "Jóvenes y Adultos",
                ageGroup = "16+ años",
                sessions = listOf(
                    "Lunes a Jueves: 20:30 hs",
                    "Viernes: 20:00 hs"
                ),
                color = SportRed
            )

            Spacer(modifier = Modifier.height(14.dp))

            LocationCard(
                sede = "Sede Pocitos",
                address = "Gabriel Pereira 3110 esq. Chucarro"
            )
        } else {
            // Sede Brazo Oriental
            ClassScheduleCard(
                category = "Tigers",
                ageGroup = "4 a 6 años",
                sessions = listOf(
                    "Martes y Jueves: 17:30 hs"
                ),
                color = Color(0xFFF97316)
            )

            Spacer(modifier = Modifier.height(10.dp))

            ClassScheduleCard(
                category = "Juniors",
                ageGroup = "7 a 11 años",
                sessions = listOf(
                    "Lunes a Viernes: 18:20 hs",
                    "Lunes, Miércoles y Viernes: 17:30 hs"
                ),
                color = Color(0xFF3B82F6)
            )

            Spacer(modifier = Modifier.height(10.dp))

            ClassScheduleCard(
                category = "Jóvenes y Adultos",
                ageGroup = "12+ años",
                sessions = listOf(
                    "Lunes a Viernes: 19:15 hs"
                ),
                color = SportRed
            )

            Spacer(modifier = Modifier.height(14.dp))

            LocationCard(
                sede = "Sede Brazo Oriental",
                address = "Av. Luis Alberto de Herrera 3448 esq. Gualeguay"
            )
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
fun ClassScheduleCard(
    category: String,
    ageGroup: String,
    sessions: List<String>,
    color: Color
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .background(color, RoundedCornerShape(3.dp))
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = category,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
                Text(
                    text = ageGroup,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            sessions.forEach { session ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 3.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Schedule,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = session,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    }
}

@Composable
fun LocationCard(sede: String, address: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
        )
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = null,
                tint = SportRed,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = sede,
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = address,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
