package me.brisson.fruits.ui.crop_season

import me.brisson.domain.model.Month

data class CropSeasonUiState(
    val loadingMonths: Boolean = true,
    val months: List<Month> = emptyList(),
    val monthsError: Throwable? = null
)
