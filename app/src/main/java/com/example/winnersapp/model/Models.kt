package com.example.winnersapp.model

import androidx.compose.ui.graphics.Color

enum class Screen(val title: String) {
    HOME("Inicio"),
    HORARIOS("Horarios de Clases"),
    NOTICIAS("Noticias Oficiales"),
    EXAMENES("Exámenes de Cinto"),
    FORMULAS("Fórmulas Tradicionales"),
    LECCION("Lección de Vida"),
    TORNEOS("Torneos y Competencias"),
    JURAMENTOS("Juramentos ATA"),
    PRECIOS("Lista de Precios"),
    REDES("Nuestras Redes"),
    ACADEMIA("La Academia")
}

data class NewsItem(
    val id: String,
    val title: String,
    val date: String,
    val content: String
)

data class FormulaItem(
    val id: String,
    val code: String,
    val title: String,
    val beltName: String,
    val beltColor: Color,
    val badgeBgColor: Color,
    val textColor: Color,
    val videoUrl: String
)

data class PriceItem(
    val id: String,
    val name: String,
    val category: String,
    val priceText: String,
    val priceValue: Int,
    val keywords: String
)

data class TournamentItem(
    val id: String,
    val dayText: String,
    val monthText: String,
    val title: String,
    val subtitle: String? = null
)

data class Candidate(
    val id: String,
    val name: String,
    val belt: String,
    val academy: String
)
