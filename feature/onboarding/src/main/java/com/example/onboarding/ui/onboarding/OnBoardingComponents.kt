package com.example.onboarding.ui.onboarding

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.brisson.ui.components.AppButton
import me.brisson.ui.theme.FruitAppTheme

@Composable
fun FirstComponent(modifier: Modifier = Modifier) {
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
            Text(
                modifier = Modifier.padding(start = 48.dp),
                text = "Pular",
                color = MaterialTheme.colors.onBackground,
                style = MaterialTheme.typography.button
            )
            val accent = Color(0XFFD253E7)
            AppButton(
                modifier = Modifier
                    .width(200.dp)
                    .padding(end = 22.dp),
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
fun SecondComponent(modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
            .padding(start = 20.dp)
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
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 22.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.padding(start = 48.dp),
                text = "Pular",
                color = MaterialTheme.colors.onBackground,
                style = MaterialTheme.typography.button
            )
            val accent = Color(0XFFD253E7)
            AppButton(
                modifier = Modifier
                    .width(200.dp)
                    .padding(end = 22.dp),
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
        FirstComponent()
    }
}

@Preview(showBackground = true, name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewSecondComponent() {
    FruitAppTheme {
        SecondComponent()
    }
}