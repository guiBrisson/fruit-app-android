package me.brisson.fruits.ui.month

import me.brisson.domain.model.Month

data class MonthUiState(
    val loading: Boolean = true,
    val month: Month? = null,
    val monthError: Throwable? = null,

    val nameArgError: Boolean = false
)
