package me.brisson.fruits.ui.crop

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.brisson.domain.model.Month
import me.brisson.fruits.preview_provider.MonthsPreviewProvider
import me.brisson.ui.theme.FruitAppTheme
import me.brisson.ui.theme.gothicA1

@Composable
fun MonthsItem(
    modifier: Modifier = Modifier,
    month: Month,
    currentMonth: Month?,
) {
    val shape = RoundedCornerShape(4.dp)
    val offSett: Dp = 2.dp

    Box {
        Box(
            modifier
                .offset(x = offSett, y = offSett)
                .matchParentSize()
                .clip(shape)
                .background(MaterialTheme.colors.onSurface)
        )
        Box(
            modifier = modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colors.onSurface,
                    shape = shape
                )
                .clip(shape)
                .background(MaterialTheme.colors.surface)
        ) {
            Column(
                modifier = Modifier.padding(
                    top = 16.dp,
                    bottom = 32.dp,
                    start = 12.dp,
                    end = 12.dp
                )
            ) {
                Text(
                    text = month.name,
                    fontFamily = gothicA1,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colors.onSurface,
                    fontSize = 18.sp
                )

                month.fruits?.let { fruits ->
                    if (fruits.isNotEmpty()) {
                        Text(
                            modifier = Modifier.padding(top = 5.dp),
                            text = "${fruits.size} frutas",
                            fontFamily = gothicA1,
                            fontWeight = FontWeight.Light,
                            color = MaterialTheme.colors.onSurface.copy(alpha = 0.6f),
                            fontSize = 12.sp,
                        )
                    }
                }
            }
            if (currentMonth == month) {
                Text(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                        .clip(shape)
                        .background(MaterialTheme.colors.onSurface)
                        .padding(horizontal = 4.dp, vertical = 1.dp),
                    text = "Mês atual",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.surface
                )
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun PreviewMonthItem(@PreviewParameter(MonthsPreviewProvider::class) months: List<Month>) {
    FruitAppTheme {
        MonthsItem(
            modifier = Modifier.padding(20.dp),
            month = months.first(),
            currentMonth = months.first()
        )
    }
}