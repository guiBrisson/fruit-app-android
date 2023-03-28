package me.brisson.nutrients.ui.preview_provider

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import me.brisson.nutrients.data.local.nutrients
import me.brisson.nutrients.domain.model.Nutrient

class NutrientsPreviewProvider : PreviewParameterProvider<List<Nutrient>> {
    override val values = sequenceOf(nutrients)
}