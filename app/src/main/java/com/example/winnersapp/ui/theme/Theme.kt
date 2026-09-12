package com.example.winnersapp.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

enum class AppThemeMode(val displayName: String) {
    BLACK("Modo Negro (Dark)"),
    CELESTE("Celeste Claro (Sky)"),
    ROJO("Tonos Rojos (Fire)"),
    VERDE("Tonos Verdes (Forest)"),
    AMARILLO("Tonos Amarillos (Gold)")
}

val SportRed = Color(0xFFE60000)
val SportAccent = Color(0xFFFF2222)
val SportGold = Color(0xFFF59E0B)

// Tema 1: Negro
private val BlackColorScheme = darkColorScheme(
    primary = SportRed,
    onPrimary = Color.White,
    primaryContainer = Color(0xFF2A1010),
    onPrimaryContainer = Color(0xFFFFDADA),
    secondary = SportGold,
    onSecondary = Color.Black,
    background = Color(0xFF0B0B0E),
    onBackground = Color(0xFFF3F4F6),
    surface = Color(0xFF18181B),
    onSurface = Color(0xFFF3F4F6),
    surfaceVariant = Color(0xFF27272A),
    onSurfaceVariant = Color(0xFFA1A1AA),
    outline = Color(0xFF3F3F46)
)

// Tema 2: Celeste
private val CelesteColorScheme = lightColorScheme(
    primary = Color(0xFF0284C7),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFBAE6FD),
    onPrimaryContainer = Color(0xFF0369A1),
    secondary = Color(0xFF0EA5E9),
    onSecondary = Color.White,
    background = Color(0xFFE0F2FE),
    onBackground = Color(0xFF0F172A),
    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF0F172A),
    surfaceVariant = Color(0xFFE2E8F0),
    onSurfaceVariant = Color(0xFF475569),
    outline = Color(0xFFBAE6FD)
)

// Tema 3: Rojo
private val RojoColorScheme = darkColorScheme(
    primary = Color(0xFFEF4444),
    onPrimary = Color.White,
    primaryContainer = Color(0xFF7F1D1D),
    onPrimaryContainer = Color(0xFFFEE2E2),
    secondary = Color(0xFFF87171),
    onSecondary = Color.Black,
    background = Color(0xFF450A0A),
    onBackground = Color(0xFFFEE2E2),
    surface = Color(0xFF581C87),
    onSurface = Color(0xFFFEE2E2),
    surfaceVariant = Color(0xFF7F1D1D),
    onSurfaceVariant = Color(0xFFFCA5A5),
    outline = Color(0xFF991B1B)
)

// Tema 4: Verde
private val VerdeColorScheme = darkColorScheme(
    primary = Color(0xFF10B981),
    onPrimary = Color.White,
    primaryContainer = Color(0xFF065F46),
    onPrimaryContainer = Color(0xFFD1FAE5),
    secondary = Color(0xFF34D399),
    onSecondary = Color.Black,
    background = Color(0xFF064E3B),
    onBackground = Color(0xFFECFDF5),
    surface = Color(0xFF065F46),
    onSurface = Color(0xFFECFDF5),
    surfaceVariant = Color(0xFF047857),
    onSurfaceVariant = Color(0xFFA7F3D0),
    outline = Color(0xFF059669)
)

// Tema 5: Amarillo
private val AmarilloColorScheme = darkColorScheme(
    primary = Color(0xFFF59E0B),
    onPrimary = Color.Black,
    primaryContainer = Color(0xFF78350F),
    onPrimaryContainer = Color(0xFFFEF3C7),
    secondary = Color(0xFFFBBF24),
    onSecondary = Color.Black,
    background = Color(0xFF451A03),
    onBackground = Color(0xFFFEF3C7),
    surface = Color(0xFF78350F),
    onSurface = Color(0xFFFEF3C7),
    surfaceVariant = Color(0xFF92400E),
    onSurfaceVariant = Color(0xFFFDE68A),
    outline = Color(0xFFB45309)
)

val AppTypography = Typography(
    titleLarge = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Black,
        fontSize = 22.sp,
        lineHeight = 28.sp
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = 24.sp
    ),
    titleSmall = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        fontSize = 15.sp,
        lineHeight = 20.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        lineHeight = 22.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        lineHeight = 18.sp
    ),
    bodySmall = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp,
        lineHeight = 15.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        fontSize = 10.sp,
        letterSpacing = 0.5.sp
    )
)

@Composable
fun WinnersTheme(
    themeMode: AppThemeMode = AppThemeMode.BLACK,
    content: @Composable () -> Unit
) {
    val colorScheme = when (themeMode) {
        AppThemeMode.BLACK -> BlackColorScheme
        AppThemeMode.CELESTE -> CelesteColorScheme
        AppThemeMode.ROJO -> RojoColorScheme
        AppThemeMode.VERDE -> VerdeColorScheme
        AppThemeMode.AMARILLO -> AmarilloColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )
}
