package me.brisson.nutrients.ui.nutrients

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import me.brisson.nutrients.domain.model.Nutrient
import me.brisson.nutrients.ui.theme.NutrientsTheme

@Composable
fun NutrientsScreen(
    modifier: Modifier = Modifier,
    viewModel: NutrientsViewModel = hiltViewModel(),
    onBack: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    var selectedNutrient by remember {
        mutableStateOf(uiState.nutrients.first())
    }

    NutrientsScreen(
        nutrient = selectedNutrient,
        onBack = onBack,
        modifier = modifier,
        nutrientsList = uiState.nutrients,
        onNutrientClick = {
            selectedNutrient = it
        })
}

@Composable
fun NutrientsScreen(
    modifier: Modifier = Modifier,
    nutrient: Nutrient,
    nutrientsList: List<Nutrient>,
    onNutrientClick: (Nutrient) -> Unit,
    onBack: () -> Unit
) {

    val scaffoldState = rememberScaffoldState()

    Scaffold(scaffoldState = scaffoldState, drawerContent = {
        NutrientsSideBar(
            nutrientsList = nutrientsList,
            selectedNutrient = nutrient,
            onItemClick = onNutrientClick
        )
    }) { scaffoldPadding ->
        LazyColumn(
            modifier = modifier
                .padding(scaffoldPadding)
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp), horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Rounded.Menu,
                            contentDescription = null,
                            tint = MaterialTheme.colors.onBackground
                        )
                    }
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.Rounded.Close,
                            contentDescription = null,
                            tint = MaterialTheme.colors.onBackground
                        )
                    }
                }
            }
            item {
                Row(
                    modifier = Modifier.padding(20.dp, bottom = 0.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Info,
                        contentDescription = null,
                        tint = MaterialTheme.colors.onBackground
                    )
                    Text(
                        modifier = Modifier.padding(start = 8.dp),
                        text = nutrient.name,
                        color = MaterialTheme.colors.onBackground,
                        fontWeight = FontWeight.Black,
                        fontSize = 24.sp
                    )
                }
                Text(
                    modifier = Modifier.padding(start = 20.dp, top = 0.dp),
                    text = nutrient.subTitle,
                    color = MaterialTheme.colors.onBackground.copy(alpha = 0.6f)
                )
            }
            itemsIndexed(nutrient.paragraphs) { index, paragraph ->
                val padding = if (index == 0) {
                    PaddingValues(top = 24.dp, start = 20.dp, end = 20.dp)
                } else {
                    PaddingValues(top = 8.dp, start = 20.dp, end = 20.dp)
                }
                Text(
                    modifier = Modifier.padding(padding),
                    text = paragraph,
                    color = MaterialTheme.colors.onBackground
                )
            }
        }
    }
}

@Preview(showBackground = true, name = "Light", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewNutrientsScreenDark() {
    NutrientsTheme {
        NutrientsScreen(nutrient = Nutrient(
            name = "Flavonoides", subTitle = "aliados da longevidade", paragraphs = listOf(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem."
            )
        ), onBack = { }, nutrientsList = emptyList(), onNutrientClick = {})
    }
}
