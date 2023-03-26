package me.brisson.fruits.preview_provider

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import me.brisson.data.model.Month

class MonthsPreviewProvider: PreviewParameterProvider<List<Month>> {
    override val values = sequenceOf(
        listOf(
            Month(name = "Janeiro", number = 1),
            Month(name = "Fevereiro", number = 2),
            Month(name = "Março", number = 3),
            Month(name = "Abril", number = 4),
            Month(name = "Maio", number = 5),
            Month(name = "Junho", number = 6),
            Month(name = "Julho", number = 7),
            Month(name = "Agosto", number = 8),
            Month(name = "Setembro", number = 9),
            Month(name = "Outrubro", number = 10),
            Month(name = "Novembro", number = 11),
            Month(name = "Dezembro", number = 12),
        )
    )
}