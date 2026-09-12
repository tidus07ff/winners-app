package com.example.winnersapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.winnersapp.model.Screen
import com.example.winnersapp.ui.components.AppTopBar
import com.example.winnersapp.ui.components.SettingsDialog
import com.example.winnersapp.ui.components.TermsDialog
import com.example.winnersapp.ui.screens.AcademiaScreen
import com.example.winnersapp.ui.screens.ExamenesScreen
import com.example.winnersapp.ui.screens.FormulasScreen
import com.example.winnersapp.ui.screens.HomeScreen
import com.example.winnersapp.ui.screens.HorariosScreen
import com.example.winnersapp.ui.screens.JuramentosScreen
import com.example.winnersapp.ui.screens.LeccionScreen
import com.example.winnersapp.ui.screens.NoticiasScreen
import com.example.winnersapp.ui.screens.PreciosScreen
import com.example.winnersapp.ui.screens.RedesScreen
import com.example.winnersapp.ui.screens.TorneosScreen
import com.example.winnersapp.ui.theme.WinnersTheme
import com.example.winnersapp.viewmodel.WinnersViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: WinnersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val themeMode by viewModel.themeMode.collectAsState()
            val brightness by viewModel.brightness.collectAsState()
            val currentScreen by viewModel.currentScreen.collectAsState()
            val hasUnreadNews by viewModel.hasUnreadNews.collectAsState()
            val selectedAcademy by viewModel.selectedAcademy.collectAsState()
            val sectionQuery by viewModel.sectionQuery.collectAsState()
            val priceQuery by viewModel.priceQuery.collectAsState()
            val candidateQuery by viewModel.candidateQuery.collectAsState()
            val isCandidatesExpanded by viewModel.isCandidatesExpanded.collectAsState()
            val expandedPriceId by viewModel.expandedPriceId.collectAsState()
            val studentName by viewModel.studentName.collectAsState()
            val studentAge by viewModel.studentAge.collectAsState()
            val studentHeight by viewModel.studentHeight.collectAsState()
            val studentAcademy by viewModel.studentAcademy.collectAsState()
            val isSettingsOpen by viewModel.isSettingsOpen.collectAsState()
            val isTermsOpen by viewModel.isTermsOpen.collectAsState()

            // Handle system back navigation
            BackHandler(enabled = currentScreen != Screen.HOME) {
                viewModel.navigateTo(Screen.HOME)
            }

            WinnersTheme(themeMode = themeMode) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    Scaffold(
                        contentWindowInsets = WindowInsets.safeDrawing,
                        topBar = {
                            AppTopBar(
                                onHomeClick = { viewModel.navigateTo(Screen.HOME) },
                                onSettingsClick = { viewModel.openSettings() }
                            )
                        },
                        containerColor = MaterialTheme.colorScheme.background
                    ) { innerPadding ->
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(innerPadding)
                        ) {
                            AnimatedContent(
                                targetState = currentScreen,
                                transitionSpec = {
                                    fadeIn() togetherWith fadeOut()
                                },
                                label = "ScreenTransition"
                            ) { screen ->
                                when (screen) {
                                    Screen.HOME -> HomeScreen(
                                        searchQuery = sectionQuery,
                                        hasUnreadNews = hasUnreadNews,
                                        onQueryChange = { viewModel.setSectionQuery(it) },
                                        onNavigate = { viewModel.navigateTo(it) }
                                    )

                                    Screen.HORARIOS -> HorariosScreen(
                                        selectedAcademy = selectedAcademy,
                                        onSelectAcademy = { viewModel.switchAcademy(it) },
                                        onBack = { viewModel.navigateTo(Screen.HOME) }
                                    )

                                    Screen.NOTICIAS -> NoticiasScreen(
                                        onBack = { viewModel.navigateTo(Screen.HOME) }
                                    )

                                    Screen.EXAMENES -> ExamenesScreen(
                                        isCandidatesExpanded = isCandidatesExpanded,
                                        candidateQuery = candidateQuery,
                                        onToggleCandidates = { viewModel.toggleCandidates() },
                                        onQueryChange = { viewModel.setCandidateQuery(it) },
                                        onBack = { viewModel.navigateTo(Screen.HOME) }
                                    )

                                    Screen.FORMULAS -> FormulasScreen(
                                        onBack = { viewModel.navigateTo(Screen.HOME) }
                                    )

                                    Screen.LECCION -> LeccionScreen(
                                        onBack = { viewModel.navigateTo(Screen.HOME) }
                                    )

                                    Screen.TORNEOS -> TorneosScreen(
                                        onBack = { viewModel.navigateTo(Screen.HOME) }
                                    )

                                    Screen.JURAMENTOS -> JuramentosScreen(
                                        onBack = { viewModel.navigateTo(Screen.HOME) }
                                    )

                                    Screen.PRECIOS -> PreciosScreen(
                                        searchQuery = priceQuery,
                                        expandedId = expandedPriceId,
                                        studentName = studentName,
                                        studentAge = studentAge,
                                        studentHeight = studentHeight,
                                        studentAcademy = studentAcademy,
                                        onSearchChange = { viewModel.setPriceQuery(it) },
                                        onToggleItem = { viewModel.togglePriceItem(it) },
                                        onUpdateForm = { n, a, h, ac -> viewModel.updateOrderForm(n, a, h, ac) },
                                        onBack = { viewModel.navigateTo(Screen.HOME) }
                                    )

                                    Screen.REDES -> RedesScreen(
                                        onBack = { viewModel.navigateTo(Screen.HOME) }
                                    )

                                    Screen.ACADEMIA -> AcademiaScreen(
                                        onBack = { viewModel.navigateTo(Screen.HOME) }
                                    )
                                }
                            }

                            // Brightness Dimmer Overlay (when brightness < 100)
                            if (brightness < 100) {
                                val dimAlpha = (100 - brightness) / 100f * 0.4f
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(Color.Black.copy(alpha = dimAlpha))
                                )
                            }
                        }
                    }

                    if (isSettingsOpen) {
                        SettingsDialog(
                            currentTheme = themeMode,
                            brightness = brightness,
                            onThemeChange = { viewModel.setTheme(it) },
                            onBrightnessChange = { viewModel.setBrightness(it) },
                            onShowTerms = { viewModel.openTerms() },
                            onDismiss = { viewModel.closeSettings() }
                        )
                    }

                    if (isTermsOpen) {
                        TermsDialog(
                            onDismiss = { viewModel.closeTerms() }
                        )
                    }
                }
            }
        }
    }
}
