package me.brisson.fruits.ui.month

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import me.brisson.domain.model.Month
import me.brisson.ui.theme.backgroundGreen

@Composable
fun MonthScreen(
    modifier: Modifier = Modifier,
    viewModel: MonthViewModel = hiltViewModel(),
    onFruit: (fruitDd: Long) -> Unit,
    onBack: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundGreen)
    ) {

        uiState.month?.let { month ->
            MonthScreen(
                modifier = Modifier,
                month = month,
                onFruit = onFruit,
                onBack = onBack
            )
        }
    }
}

@Composable
internal fun MonthScreen(
    modifier: Modifier = Modifier,
    month: Month?,
    onFruit: (fruitDd: Long) -> Unit,
    onBack: () -> Unit,
) {
    LazyColumn(modifier = modifier) {
        item {
            IconButton(modifier = Modifier.padding(top = 10.dp, start = 10.dp), onClick = onBack) {
                Icon(imageVector = Icons.Rounded.ArrowBackIosNew, contentDescription = null)
            }
        }

        month?.let { month ->
            item {
                Text(
                    modifier = modifier.padding(horizontal = 20.dp),
                    text = month.name,
                    style = MaterialTheme.typography.h1
                )
            }

            month.fruits?.let { fruits ->
                items(fruits) { fruit ->
                    // TODO
                }
            }
        }

    }
}
