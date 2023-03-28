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
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.launch
import me.brisson.nutrients.domain.model.Nutrient
import me.brisson.nutrients.ui.preview_provider.NutrientsPreviewProvider
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

    if (uiState.nutrients.isNotEmpty()) {
        NutrientsScreen(
            modifier = modifier,
            nutrients = uiState.nutrients,
            lastSelectedNutrient = viewModel.getLastOpenedNutrient(),
            onSaveLastNutrient = { id -> viewModel.saveCurrentNutrient(id) },
            onHome = onHome,
            onBack = onBack
        )
    } else {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            contentAlignment = Alignment.Center
        ) {
            EmptyListNutrient(
                modifier = Modifier.padding(horizontal = 50.dp),
                onReload = viewModel::insertNutrientsOnDb
            )
        }
    }

}

@Composable
internal fun NutrientsScreen(
    modifier: Modifier = Modifier,
    nutrients: List<Nutrient>,
    lastSelectedNutrient: Nutrient? = null,
    onSaveLastNutrient: (nutrientId: Long) -> Unit,
    onHome: () -> Unit,
    onBack: () -> Unit
) {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    var selectedNutrient by remember {
        mutableStateOf(lastSelectedNutrient ?: nutrients.first())
    }

    onSaveLastNutrient(selectedNutrient.id)

    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            NutrientsSideBar(
                nutrientsList = nutrients,
                selectedNutrient = selectedNutrient,
                onItemClick = { nutrient -> selectedNutrient = nutrient }
            )
        }
    ) { scaffoldPadding ->

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
                    color = MaterialTheme.colors.onBackground.copy(alpha = 0.6f),
                    fontSize = 16.sp
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
                    color = MaterialTheme.colors.onBackground,
                    fontSize = 16.sp
                )
            }
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    val selectedIndex = nutrients.indexOf(selectedNutrient)

                    val nextNutrient: Nutrient? =
                        if (selectedIndex != nutrients.lastIndex) {
                            nutrients[selectedIndex + 1]
                        } else null

                    AppButton(
                        modifier = Modifier
                            .width(200.dp)
                            .padding(top = 40.dp, end = 20.dp, bottom = 30.dp),
                        backgroundColor = MaterialTheme.colors.surface,
                        accentColor = MaterialTheme.colors.primary,
                        borderColor = MaterialTheme.colors.primary,
                        trailingIcon = {
                            if (nextNutrient == null) {
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
                                val text = nextNutrient?.name ?: "Voltar"
                                Text(text = text, fontSize = 16.sp)
                                nextNutrient?.let {
                                    Text(
                                        modifier = Modifier.offset(y = (-4).dp),
                                        text = "Próximo capítulo",
                                        color = MaterialTheme.colors.onBackground.copy(alpha = 0.6f),
                                        fontSize = 12.sp,
                                    )
                                }
                            }
                        },
                        onClick = {
                            if (nextNutrient == null) {
                                onHome()
                            } else {
                                selectedNutrient = nextNutrient
                            }
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "Light", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewNutrientsScreen(@PreviewParameter(NutrientsPreviewProvider::class) nutrients: List<Nutrient>) {
    NutrientsTheme {
        NutrientsScreen(
            onBack = { },
            nutrients = nutrients,
            onSaveLastNutrient = { },
            onHome = { },
        )
    }
}
