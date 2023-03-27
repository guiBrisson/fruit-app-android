package me.brisson.fruits.preview_provider

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import me.brisson.domain.model.Fruit
import me.brisson.domain.model.Month

class FruitPreviewProvider : PreviewParameterProvider<List<Fruit>> {
    override val values = sequenceOf(
        listOf(
            Fruit(
                name = "Manga",
                imageUrl = "https://images.unsplash.com/photo-1582655299221-2b6bff351df0?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=881&q=80",
                summary = "Controla a pressão arterial",
                isFavorite = true,
                months = listOf(
                    Month("Janeiro", 1),
                    Month("Fevereiro", 2),
                )
            )
        )
    )
}