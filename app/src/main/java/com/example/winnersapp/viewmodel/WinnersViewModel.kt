package com.example.winnersapp.viewmodel

import android.app.Application
import android.content.Context
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import com.example.winnersapp.model.Screen
import com.example.winnersapp.ui.theme.AppThemeMode
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

class WinnersViewModel(application: Application) : AndroidViewModel(application) {

    private val prefs = application.getSharedPreferences("wfl_prefs", Context.MODE_PRIVATE)

    private val _currentScreen = MutableStateFlow(Screen.HOME)
    val currentScreen: StateFlow<Screen> = _currentScreen.asStateFlow()

    private val _themeMode = MutableStateFlow(
        try {
            AppThemeMode.valueOf(prefs.getString("theme", AppThemeMode.BLACK.name) ?: AppThemeMode.BLACK.name)
        } catch (e: Exception) {
            AppThemeMode.BLACK
        }
    )
    val themeMode: StateFlow<AppThemeMode> = _themeMode.asStateFlow()

    private val _brightness = MutableStateFlow(prefs.getInt("brightness", 100))
    val brightness: StateFlow<Int> = _brightness.asStateFlow()

    private val _hasUnreadNews = MutableStateFlow(!prefs.getBoolean("news_read_v3", false))
    val hasUnreadNews: StateFlow<Boolean> = _hasUnreadNews.asStateFlow()

    private val _selectedAcademy = MutableStateFlow("pocitos")
    val selectedAcademy: StateFlow<String> = _selectedAcademy.asStateFlow()

    private val _sectionQuery = MutableStateFlow("")
    val sectionQuery: StateFlow<String> = _sectionQuery.asStateFlow()

    private val _priceQuery = MutableStateFlow("")
    val priceQuery: StateFlow<String> = _priceQuery.asStateFlow()

    private val _candidateQuery = MutableStateFlow("")
    val candidateQuery: StateFlow<String> = _candidateQuery.asStateFlow()

    private val _isCandidatesExpanded = MutableStateFlow(false)
    val isCandidatesExpanded: StateFlow<Boolean> = _isCandidatesExpanded.asStateFlow()

    private val _expandedPriceId = MutableStateFlow<String?>(null)
    val expandedPriceId: StateFlow<String?> = _expandedPriceId.asStateFlow()

    // Form inputs for equipment order
    private val _studentName = MutableStateFlow("")
    val studentName: StateFlow<String> = _studentName.asStateFlow()

    private val _studentAge = MutableStateFlow("")
    val studentAge: StateFlow<String> = _studentAge.asStateFlow()

    private val _studentHeight = MutableStateFlow("")
    val studentHeight: StateFlow<String> = _studentHeight.asStateFlow()

    private val _studentAcademy = MutableStateFlow("Winners Pocitos")
    val studentAcademy: StateFlow<String> = _studentAcademy.asStateFlow()

    // Modals
    private val _isSettingsOpen = MutableStateFlow(false)
    val isSettingsOpen: StateFlow<Boolean> = _isSettingsOpen.asStateFlow()

    private val _isTermsOpen = MutableStateFlow(false)
    val isTermsOpen: StateFlow<Boolean> = _isTermsOpen.asStateFlow()

    fun navigateTo(screen: Screen) {
        _currentScreen.value = screen
        if (screen == Screen.NOTICIAS) {
            markNewsRead()
        }
    }

    fun switchAcademy(tab: String) {
        _selectedAcademy.value = tab
    }

    fun setTheme(mode: AppThemeMode) {
        _themeMode.value = mode
        prefs.edit().putString("theme", mode.name).apply()
    }

    fun setBrightness(percent: Int) {
        val clamped = percent.coerceIn(70, 100)
        _brightness.value = clamped
        prefs.edit().putInt("brightness", clamped).apply()
    }

    fun markNewsRead() {
        _hasUnreadNews.value = false
        prefs.edit().putBoolean("news_read_v3", true).apply()
    }

    fun setSectionQuery(query: String) {
        _sectionQuery.value = query
    }

    fun setPriceQuery(query: String) {
        _priceQuery.value = query
    }

    fun setCandidateQuery(query: String) {
        _candidateQuery.value = query
    }

    fun toggleCandidates() {
        _isCandidatesExpanded.value = !_isCandidatesExpanded.value
    }

    fun togglePriceItem(id: String) {
        if (_expandedPriceId.value == id) {
            _expandedPriceId.value = null
        } else {
            _expandedPriceId.value = id
        }
    }

    fun updateOrderForm(name: String, age: String, height: String, academy: String) {
        _studentName.value = name
        _studentAge.value = age
        _studentHeight.value = height
        _studentAcademy.value = academy
    }

    fun openSettings() {
        _isSettingsOpen.value = true
    }

    fun closeSettings() {
        _isSettingsOpen.value = false
    }

    fun openTerms() {
        _isTermsOpen.value = true
    }

    fun closeTerms() {
        _isTermsOpen.value = false
    }

    fun createWhatsAppUrl(article: String): String {
        val name = _studentName.value.trim()
        val age = _studentAge.value.trim()
        val height = _studentHeight.value.trim()
        val academy = _studentAcademy.value.trim()

        val text = "Saludos! me gustaria adquirir $article.\n" +
                "Nombre y apellido del estudiante: $name\n" +
                "Edad del estudiante: $age\n" +
                "Altura del estudiante: $height\n" +
                "Academia: $academy"

        val encoded = URLEncoder.encode(text, StandardCharsets.UTF_8.toString())
        return "https://wa.me/59891809219?text=$encoded"
    }
}
