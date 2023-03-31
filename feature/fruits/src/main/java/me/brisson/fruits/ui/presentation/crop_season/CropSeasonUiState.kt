package me.brisson.fruits.ui.presentation.crop_season

import me.brisson.domain.model.Month

data class CropSeasonUiState(
    val loadingMonths: Boolean = true,
    val months: List<Month> = emptyList(),
    val monthsError: Throwable? = null
)
