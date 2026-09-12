package com.example.winnersapp.data

import androidx.compose.ui.graphics.Color
import com.example.winnersapp.model.FormulaItem
import com.example.winnersapp.model.NewsItem
import com.example.winnersapp.model.PriceItem
import com.example.winnersapp.model.TournamentItem

object DataProvider {

    val formulas = listOf(
        FormulaItem(
            id = "s1",
            code = "1",
            title = "Songham 1",
            beltName = "Cinturón Blanco",
            beltColor = Color.White,
            badgeBgColor = Color.White,
            textColor = Color(0xFF1F2937),
            videoUrl = "https://www.youtube.com/watch?v=71d4-MkyZs0"
        ),
        FormulaItem(
            id = "s2",
            code = "2",
            title = "Songham 2",
            beltName = "Cinturón Naranja",
            beltColor = Color(0xFFF97316),
            badgeBgColor = Color(0xFFF97316),
            textColor = Color.White,
            videoUrl = "https://www.youtube.com/watch?v=6q2oafhIBbM"
        ),
        FormulaItem(
            id = "s3",
            code = "3",
            title = "Songham 3",
            beltName = "Cinturón Amarillo",
            beltColor = Color(0xFFFACC15),
            badgeBgColor = Color(0xFFFACC15),
            textColor = Color(0xFF18181B),
            videoUrl = "https://www.youtube.com/watch?v=IhHUvMwey2Y"
        ),
        FormulaItem(
            id = "s4",
            code = "4",
            title = "Songham 4",
            beltName = "Cinturón Camuflaje",
            beltColor = Color(0xFF059669),
            badgeBgColor = Color(0xFF383E18),
            textColor = Color.White,
            videoUrl = "https://www.youtube.com/watch?v=ZMi83SPAP1Q"
        ),
        FormulaItem(
            id = "s5",
            code = "5",
            title = "Songham 5",
            beltName = "Cinturón Verde",
            beltColor = Color(0xFF16A34A),
            badgeBgColor = Color(0xFF16A34A),
            textColor = Color.White,
            videoUrl = "https://www.youtube.com/watch?v=R-tqIae7CUY"
        ),
        FormulaItem(
            id = "iw1",
            code = "IW1",
            title = "In-Wha 1",
            beltName = "Cinturón Violeta",
            beltColor = Color(0xFFA855F7),
            badgeBgColor = Color(0xFF9333EA),
            textColor = Color.White,
            videoUrl = "https://www.youtube.com/watch?v=BYnbVnx4zlI"
        ),
        FormulaItem(
            id = "iw2",
            code = "IW2",
            title = "In-Wha 2",
            beltName = "Cinturón Azul",
            beltColor = Color(0xFF3B82F6),
            badgeBgColor = Color(0xFF2563EB),
            textColor = Color.White,
            videoUrl = "https://www.youtube.com/watch?v=0M2eU1fgSXw"
        ),
        FormulaItem(
            id = "cj1",
            code = "CJ1",
            title = "Choong-Jung 1",
            beltName = "Cinturón Marrón",
            beltColor = Color(0xFFB45309),
            badgeBgColor = Color(0xFF92400E),
            textColor = Color.White,
            videoUrl = "https://www.youtube.com/watch?v=_EHpSG0cBX8"
        ),
        FormulaItem(
            id = "cj2",
            code = "CJ2",
            title = "Choong-Jung 2",
            beltName = "Cinturón Rojo",
            beltColor = Color(0xFFE60000),
            badgeBgColor = Color(0xFFE60000),
            textColor = Color.White,
            videoUrl = "https://www.youtube.com/watch?v=7Fp2N_1GvnQ"
        )
    )

    val prices = listOf(
        PriceItem("p1", "Uniforme", "Indumentaria", "$3.000", 3000, "uniforme indumentaria ropa dobok"),
        PriceItem("p2", "Cabezal", "Protección", "$2.000", 2000, "cabezal protección casco cabeza"),
        PriceItem("p3", "Guantes", "Protección", "$2.000", 2000, "guantes protección manos spar"),
        PriceItem("p4", "Pies", "Protección", "$2.000", 2000, "pies protección zapatillas botas"),
        PriceItem("p5", "Pechera", "Protección", "$2.000", 2000, "pechera protección torso pecho"),
        PriceItem("p6", "Bucal", "Protección", "$200", 200, "bucal protección boca dientes"),
        PriceItem("p7", "Máscara", "Protección", "$2.000", 2000, "máscara protección cara visor"),
        PriceItem("p8", "Bolso", "Accesorios", "$1.600", 1600, "bolso accesorios mochila mochila"),
        PriceItem("p9", "Inguinal", "Protección", "$750", 750, "inguinal protección concha"),
        PriceItem("p10", "Tibiales", "Protección", "$1.750", 1750, "tibiales protección piernas canilleras"),
        PriceItem("p11", "Combo de Protectores", "Kit Completo", "$12.870", 12870, "combo de protectores kit completo pack"),
        PriceItem("p12", "Palo Corto", "Armas", "$1.200", 1200, "palo corto armas bahng mahng ee stick"),
        PriceItem("p13", "Nun-Chacku", "Armas", "$1.250", 1250, "nun-chacku armas nunchaku"),
        PriceItem("p14", "Palo Combat", "Armas", "$1.300", 1300, "palo combat armas combat"),
        PriceItem("p15", "Combat Tiger", "Armas", "$1.350", 1350, "combat tiger armas"),
        PriceItem("p16", "Sshang-Nat", "Armas", "$1.450", 1450, "sshang-nat armas kama"),
        PriceItem("p17", "Palo Largo", "Armas", "$1.500", 1500, "palo largo armas bo staff"),
        PriceItem("p18", "Espada", "Armas", "$1.600", 1600, "espada armas katana gum do")
    )

    val news = listOf(
        NewsItem(
            id = "n1",
            title = "¡La app ya está lista!",
            date = "11 de Septiembre de 2026",
            content = "La app ya está lista para descargar y usar. Puede que haya ajustes en los próximos días."
        ),
        NewsItem(
            id = "n2",
            title = "Renovación en la Academia",
            date = "07 de Septiembre de 2026",
            content = "Pintamos la academia y le hicieron un increíble arte en sus paredes. ¡Te invitamos a conocer las nuevas instalaciones!"
        ),
        NewsItem(
            id = "n3",
            title = "Entrega de Cinturones",
            date = "07 de Septiembre de 2026",
            content = "Celebramos la entrega de cinturones para todos los graduados que rindieron su examen hace unos días. ¡Felicitaciones a todos por su avance y esfuerzo!"
        )
    )

    val tournaments = listOf(
        TournamentItem(
            id = "t1",
            dayText = "12",
            monthText = "SET",
            title = "Torneo Nacional por Equipos"
        ),
        TournamentItem(
            id = "t2",
            dayText = "22-25",
            monthText = "OCT",
            title = "Torneo Panamericano",
            subtitle = "(Mendoza, Argentina)"
        ),
        TournamentItem(
            id = "t3",
            dayText = "29",
            monthText = "NOV",
            title = "Torneo Nacional"
        )
    )
}
