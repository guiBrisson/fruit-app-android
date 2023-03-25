package me.brisson.nutrients.ui.nutrients

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import me.brisson.nutrients.ui.theme.NutrientsTheme

@Composable
fun NutrientsScreen(
    modifier: Modifier = Modifier,
    viewModel: NutrientsViewModel = hiltViewModel(),
    onBack: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(modifier = modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.background)) {
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
                text = "Flavinoides",
                color = MaterialTheme.colors.onBackground,
                fontWeight = FontWeight.Black,
                fontSize = 24.sp
            )
        }
        Text(
            modifier = Modifier.padding(start = 20.dp, top = 0.dp),
            text = "aliados da longevidade",
            color = MaterialTheme.colors.onBackground.copy(alpha = 0.6f)
        )
        Text(text = "")
    }
}

@Preview(showBackground = true, name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PreviewNutrientsScreenDark() {
    NutrientsTheme {
        NutrientsScreen(onBack = { })
    }
}

@Preview(showBackground = true, name = "Light", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewNutrientsScreenLight() {
    NutrientsTheme {
        NutrientsScreen(onBack = { })
    }
}