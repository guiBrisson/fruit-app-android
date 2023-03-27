package me.brisson.fruits.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import me.brisson.domain.model.Fruit
import me.brisson.ui.theme.FruitAppTheme
import me.brisson.ui.theme.backgroundOrange
import me.brisson.ui.theme.backgroundPurple
import me.brisson.ui.theme.gothicA1

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    onNutrients: () -> Unit,
    onCrops: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsState()

    HomeScreen(
        modifier = modifier,
        fruits = uiState.fruits,
        onNutrients = onNutrients,
        onCrops = onCrops
    )

}

@Composable
internal fun HomeScreen(
    modifier: Modifier = Modifier,
    fruits: List<Fruit>,
    onNutrients: () -> Unit,
    onCrops: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundPurple)
            .padding(20.dp)
    ) {
        Text(text = "Bom dia", fontFamily = gothicA1, fontSize = 24.sp)
        Box(modifier = Modifier.padding(top = 12.dp)) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .offset(x = 2.dp, y = 2.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(MaterialTheme.colors.onBackground)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(4.dp))
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colors.onBackground,
                        shape = RoundedCornerShape(4.dp)
                    )
                    .background(MaterialTheme.colors.surface)
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val contentColor = MaterialTheme.colors.onSurface.copy(alpha = 0.6f)
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = null,
                    tint = contentColor
                )
                Text(
                    modifier = Modifier.padding(start = 16.dp),
                    text = "Search",
                    color = contentColor,
                    fontFamily = gothicA1,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }

        Row(
            modifier = Modifier
                .padding(top = 16.dp)
                .height(IntrinsicSize.Max),
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            HomeItem(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable(onClick = onCrops),
                title = "Safra das frutas",
                subTitle = "Aposte nas frutas da estação para garantir tudo o que elas podem oferecer o seu organismo"
            )
            HomeItem(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable(onClick = onNutrients),
                title = "Um mar de nutrientes",
                backgroundColor = backgroundOrange,
                subTitle = "Conheça os componentes das frutas mas consumidas no Brasil"
            )
        }

        Text(
            modifier = Modifier.padding(top = 24.dp),
            text = "Frutas favoritas",
            style = MaterialTheme.typography.h3
        )

        fruits.forEach {
            Text("${it.name} ${it.months}")
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    FruitAppTheme {
        HomeScreen(fruits = emptyList(), onNutrients = { }, onCrops = { })
    }
}