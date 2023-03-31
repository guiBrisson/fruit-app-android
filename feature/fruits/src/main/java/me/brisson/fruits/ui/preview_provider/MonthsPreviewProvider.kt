package me.brisson.fruits.ui.preview_provider

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import me.brisson.domain.model.Fruit
import me.brisson.domain.model.Month

class MonthsPreviewProvider: PreviewParameterProvider<List<Month>> {
    private val someFruits = listOf(
        Fruit(
            name = "Mamão",
            imageUrl = "https://images.unsplash.com/photo-1517282009859-f000ec3b26fe?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80",
            summary = "era uma vez um mamão",
            isFavorite = true,
        ),
        Fruit(
            name = "Banana",
            imageUrl = "https://images.unsplash.com/photo-1528825871115-3581a5387919?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=715&q=80",
            summary = "era uma vez uma banana",
            isFavorite = false,
        ),
    )
    override val values = sequenceOf(
        listOf(
            Month(name = "Janeiro", number = 1, fruits = someFruits),
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