package me.brisson.fruits.ui.preview_provider

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import me.brisson.domain.fruits
import me.brisson.domain.model.Fruit

class FruitPreviewProvider : PreviewParameterProvider<List<Fruit>> {
    override val values = sequenceOf(fruits)
}