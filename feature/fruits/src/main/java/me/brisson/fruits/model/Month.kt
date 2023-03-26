package me.brisson.fruits.model

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

data class Month(
    val id: Long = 0,
    val name: String
)

class MonthsPreviewProvider: PreviewParameterProvider<List<Month>> {
    override val values = sequenceOf(
        listOf(
            Month(name = "Janeiro"),
            Month(name = "Fevereiro"),
            Month(name = "Março"),
            Month(name = "Abril"),
            Month(name = "Maio"),
            Month(name = "Junho"),
            Month(name = "Julho"),
            Month(name = "Agosto"),
            Month(name = "Setembro"),
            Month(name = "Outrubro"),
            Month(name = "Novembro"),
            Month(name = "Dezembro"),
        )
    )
}