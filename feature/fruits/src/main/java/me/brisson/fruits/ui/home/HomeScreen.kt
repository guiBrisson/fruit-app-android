package me.brisson.fruits.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import me.brisson.domain.model.Fruit
import me.brisson.fruits.preview_provider.FruitPreviewProvider
import me.brisson.ui.components.FruitVerticalItem
import me.brisson.ui.components.SearchBar
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
    var value by remember { mutableStateOf("") }
    val focusRequester = FocusRequester()
    val focusManager = LocalFocusManager.current
    var editTextHasFocus by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundPurple)
            .padding(20.dp)
    ) {
        item {
            Text(text = "Bom dia", fontFamily = gothicA1, fontSize = 24.sp)
        }
        item {
            SearchBar(
                modifier = Modifier
                    .padding(top = 12.dp)
                    .focusRequester(focusRequester)
                    .onFocusChanged { editTextHasFocus = it.hasFocus },
                value = value,
                onValueChange = { value = it },
                label = {
                    Text("Search")
                },
                hasFocus = editTextHasFocus,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(onSearch = {
                    focusManager.clearFocus()
                    //TODO: Navigate to search screen
                })
            )
        }

        item {
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
        }

        item {
            Text(
                modifier = Modifier.padding(top = 24.dp),
                text = "Frutas",
                style = MaterialTheme.typography.h3
            )
        }

        itemsIndexed(fruits) { index, fruit ->
            val paddingValues = if (index == 0) {
                PaddingValues(top = 12.dp, bottom = 8.dp)
            } else {
                PaddingValues(vertical = 4.dp)
            }

            FruitVerticalItem(
                modifier = Modifier.padding(paddingValues),
                fruit = fruit,
                onFavorite = { }
            )
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen(@PreviewParameter(FruitPreviewProvider::class) fruits: List<Fruit>) {
    FruitAppTheme {
        HomeScreen(fruits = fruits, onNutrients = { }, onCrops = { })
    }
}