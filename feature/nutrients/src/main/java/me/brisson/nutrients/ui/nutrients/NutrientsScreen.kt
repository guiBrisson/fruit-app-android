package me.brisson.nutrients.ui.nutrients

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.launch
import me.brisson.nutrients.domain.model.Nutrient
import me.brisson.nutrients.ui.theme.NutrientsTheme
import me.brisson.ui.components.AppButton

@Composable
fun NutrientsScreen(
    modifier: Modifier = Modifier,
    viewModel: NutrientsViewModel = hiltViewModel(),
    onHome: () -> Unit,
    onBack: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    var selectedNutrient by remember {
        mutableStateOf<Nutrient?>(null)
    }

    selectedNutrient?.let { nutrient ->
        NutrientsScreen(
            uiState = uiState,
            onBack = onBack,
            modifier = modifier,
            selectedNutrient = nutrient,
            onHome = onHome,
            onNutrientClick = { n ->
                viewModel.findNextNutrient(n)
                selectedNutrient = n
            }
        )
    }
}

@Composable
internal fun NutrientsScreen(
    modifier: Modifier = Modifier,
    uiState: NutrientsUiState,
    selectedNutrient: Nutrient,
    onNutrientClick: (Nutrient) -> Unit,
    onHome: () -> Unit,
    onBack: () -> Unit
) {

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(scaffoldState = scaffoldState, drawerContent = {
        NutrientsSideBar(
            nutrientsList = uiState.nutrients,
            selectedNutrient = selectedNutrient,
            onItemClick = onNutrientClick
        )
    }) { scaffoldPadding ->
        Column(
            modifier = modifier
                .padding(scaffoldPadding)
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
        ) {
            LazyColumn {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp), horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        IconButton(onClick = {
                            coroutineScope.launch {
                                scaffoldState.drawerState.open()
                            }
                        }) {
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
                            text = selectedNutrient.name,
                            color = MaterialTheme.colors.onBackground,
                            fontWeight = FontWeight.Black,
                            fontSize = 24.sp
                        )
                    }
                    Text(
                        modifier = Modifier.padding(start = 20.dp, top = 0.dp),
                        text = selectedNutrient.subTitle,
                        color = MaterialTheme.colors.onBackground.copy(alpha = 0.6f)
                    )
                }
                itemsIndexed(selectedNutrient.paragraphs) { index, paragraph ->
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
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                AppButton(
                    modifier = Modifier
                        .width(200.dp)
                        .padding(top = 40.dp, end = 20.dp, bottom = 30.dp),
                    backgroundColor = MaterialTheme.colors.surface,
                    accentColor = MaterialTheme.colors.primary,
                    borderColor = MaterialTheme.colors.primary,
                    trailingIcon = {
                        if (uiState.nextNutrient == null) {
                            Icon(
                                imageVector = Icons.Rounded.Home,
                                contentDescription = null
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Rounded.ArrowForward,
                                contentDescription = null
                            )
                        }
                    },
                    text = {
                        Column {
                            val text = uiState.nextNutrient?.name ?: "Voltar"
                            Text(text = text)
                            uiState.nextNutrient?.let {
                                Text(
                                    text = "Próximo capítulo",
                                    color = MaterialTheme.colors.onBackground.copy(alpha = 0.6f)
                                )
                            }
                        }
                    },
                    onClick = {
                        if (uiState.nextNutrient == null) {
                            onHome()
                        } else {
                            onNutrientClick(uiState.nextNutrient)
                        }
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true, name = "Light", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewNutrientsScreenDark() {
    val nutrients = listOf(
        Nutrient(
            id = 1,
            name = "Flavonoides",
            subTitle = "Melhor amigo dos Flávios",
            paragraphs = listOf(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
            )
        ),
        Nutrient(
            id = 2,
            name = "Vitamina C",
            subTitle = "Melhor amigo dos velhos",
            paragraphs = listOf(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem."
            )
        )
    )
    NutrientsTheme {
        NutrientsScreen(
            selectedNutrient = nutrients[0],
            onBack = { },
            uiState = NutrientsUiState(nutrients = nutrients),
            onHome = { },
            onNutrientClick = {})
    }
}
