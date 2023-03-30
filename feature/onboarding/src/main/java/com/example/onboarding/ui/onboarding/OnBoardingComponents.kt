package com.example.onboarding.ui.onboarding

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.brisson.ui.components.AppButton
import me.brisson.ui.components.SearchBar
import me.brisson.ui.theme.FruitAppTheme

@Composable
fun FirstComponent(
    modifier: Modifier = Modifier,
    onSkip: () -> Unit,
    onContinue: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
    ) {
        Text(
            modifier = Modifier.padding(start = 26.dp, top = 30.dp, bottom = 12.dp),
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.onBackground,
            text = "Atenção!"
        )
        Text(
            modifier = Modifier.padding(start = 26.dp, bottom = 35.dp, end = 32.dp),
            style = MaterialTheme.typography.subtitle1,
            color = MaterialTheme.colors.onBackground.copy(alpha = 0.6f),
            text = "Todas as informações geradas por você não vão sair do seu celular. Isso significa que se você desinstalar o app as mesmas serão perdidas, pois não existe nenhuma conexão com um banco de dados externo."
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 22.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextButton(modifier = Modifier.padding(start = 48.dp), onClick = onSkip) {
                Text(
                    text = "Pular",
                    color = MaterialTheme.colors.onBackground,
                    style = MaterialTheme.typography.button
                )
            }
            val accent = Color(0XFFD253E7)
            AppButton(
                modifier = Modifier
                    .width(200.dp)
                    .padding(end = 22.dp)
                    .clickable { onContinue() },
                backgroundColor = MaterialTheme.colors.background,
                borderColor = Color.Black,
                accentColor = accent,
                text = {
                    Text(
                        text = "Continuar",
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.button
                    )
                })
        }
    }
}

@Composable
fun SecondComponent(
    modifier: Modifier = Modifier,
    onSkip: () -> Unit,
    onEnter: (userName: String) -> Unit
) {
    val focusRequester = FocusRequester()
    val focusManager = LocalFocusManager.current
    var editTextHasFocus by remember { mutableStateOf(false) }
    var value by remember {
        mutableStateOf("")
    }

    Column(
        modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
            .padding(horizontal = 20.dp)
    ) {
        Text(
            modifier = Modifier.padding(bottom = 10.dp, top = 24.dp),
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.onBackground,
            text = "Como devemos te chamar?"
        )
        Text(
            modifier = Modifier.padding(bottom = 28.dp),
            style = MaterialTheme.typography.subtitle1,
            color = MaterialTheme.colors.onBackground.copy(alpha = 0.6f),
            text = "Não precisa ser seu nome, pode ser qualquer coisa."
        )
        SearchBar(modifier = Modifier
            .padding(bottom = 42.dp)
            .focusRequester(focusRequester)
            .onFocusChanged { editTextHasFocus = it.hasFocus },
            value = value,
            label = { Text(text = "John Doe") },
            hasFocus = editTextHasFocus,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
            onValueChange = { value = it }
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 22.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextButton(modifier = Modifier.padding(start = 28.dp), onClick = onSkip) {
                Text(
                    text = "Pular",
                    color = MaterialTheme.colors.onBackground,
                    style = MaterialTheme.typography.button
                )
            }
            val accent = Color(0XFFD253E7)
            AppButton(
                modifier = Modifier
                    .width(200.dp)
                    .clickable { onEnter(value) },
                backgroundColor = MaterialTheme.colors.background,
                borderColor = Color.Black,
                accentColor = accent,
                text = {
                    Text(
                        text = "Entrar",
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.button
                    )
                })
        }
    }
}

@Preview(showBackground = true, name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewFirstComponent() {
    FruitAppTheme {
        FirstComponent(onSkip = {}, onContinue = {})
    }
}

@Preview(showBackground = true, name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewSecondComponent() {
    FruitAppTheme {
        SecondComponent(onSkip = {}, onEnter = {})
    }
}