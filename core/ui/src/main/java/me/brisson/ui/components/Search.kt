package me.brisson.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.brisson.ui.theme.FruitAppTheme

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    value: String,
    label: @Composable () -> Unit,
    hasFocus: Boolean,
    onValueChange: (String) -> Unit,
    cursorBrush: Brush = SolidColor(Color.Black),
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .matchParentSize()
                .offset(x = 2.dp, y = 2.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(MaterialTheme.colors.onBackground)
        )

        BasicTextField(
            modifier = Modifier,
            value = value,
            onValueChange = onValueChange,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            cursorBrush = cursorBrush,
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .defaultMinSize(minHeight = 50.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colors.onBackground,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .background(MaterialTheme.colors.surface)
                        .padding(12.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (!hasFocus && value.isEmpty()) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                modifier = Modifier.padding(end = 4.dp),
                                imageVector = Icons.Rounded.Search,
                                contentDescription = null,
                                tint = Color.Black
                            )
                            label()
                        }
                    }
                    innerTextField()
                }
            }
        )

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSearchBar() {
    FruitAppTheme {
        var value by remember { mutableStateOf("") }

        SearchBar(
            modifier = Modifier.padding(10.dp),
            value = value,
            hasFocus = false,
            label = {
                Text("Label")
            },
            onValueChange = { value = it }
        )
    }
}