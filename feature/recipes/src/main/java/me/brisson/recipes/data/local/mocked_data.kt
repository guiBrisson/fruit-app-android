package me.brisson.recipes.data.local

import me.brisson.recipes.domain.model.Ingredient
import me.brisson.recipes.domain.model.Recipe

val recipeTest = Recipe(
    name = "Arroz doce de coco",
    portions = "6",
    calories = 380,
    preparationTime = 5,
    waitingTime = 35,
    ingredients = listOf(
        Ingredient(
            name = "arroz branco",
            amount = "1",
            unitMeasurement = "xícara"
        ),
        Ingredient(
            name = "água",
            amount = "2",
            unitMeasurement = "xícaras"
        ),
        Ingredient(
            name = "leite condensado",
            amount = "1",
            unitMeasurement = "lata",
            observations = listOf("use a lata de leite condensado vazia para medir")
        ),
        Ingredient(
            name = "coco ralado",
            amount = "1",
            unitMeasurement = "xícara",
        ),
        Ingredient(
            name = "canela",
            amount = "1",
            unitMeasurement = "pau",
        ),
        Ingredient(
            name = "cravos-da-índia",
            amount = "4",
        ),
        Ingredient(
            name = "sal",
            amount = "1",
            unitMeasurement = "pitada"
        ),

    ),
    instructions = listOf(
        "Lave o arroz e coloque-o em uma panela com a água, canela em pau, cravos-da-índia e sal. Leve ao fogo médio e deixe cozinhar até que a água tenha sido absorvida e o arroz esteja macio.",
        "Adicione o leite condensado, leite e coco ralado à panela e mexa até obter uma mistura homogênea.",
        "Cozinhe em fogo baixo por cerca de 15 minutos, mexendo ocasionalmente, até que o arroz doce tenha engrossado e esteja cremoso.",
        "Despeje o arroz doce em um recipiente, deixe esfriar por alguns minutos e sirva."
    )
)