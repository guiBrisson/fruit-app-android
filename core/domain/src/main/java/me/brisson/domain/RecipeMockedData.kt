package me.brisson.domain

import me.brisson.domain.model.Ingredient
import me.brisson.domain.model.Recipe

val arrozDoceDeCoco = Recipe(
    id = 1,
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

val boloDeCoco = Recipe(
    id = 2,
    name = "Bolo de coco",
    portions = "10-12 fatias",
    calories = 280,
    preparationTime = 15,
    waitingTime = 40,
    ingredients = listOf(
        Ingredient(
            name = "óleo",
            amount = "1/2",
            unitMeasurement = "xícara"
        ),
        Ingredient(
            name = "açucar",
            amount = "1",
            unitMeasurement = "xícara"
        ),
        Ingredient(
            name = "ovos",
            amount = "3",
        ),
        Ingredient(
            name = "farinha de trigo",
            amount = "1",
            unitMeasurement = "xícara"
        ),
        Ingredient(
            name = "coco ralado",
            amount = "1",
            unitMeasurement = "xícara"
        ),
        Ingredient(
            name = "fermento em pó",
            amount = "1",
            unitMeasurement = "colher de sopa"
        ),
        Ingredient(
            name = "leite",
            amount = "1/2",
            unitMeasurement = "xícara"
        ),
    ),
    instructions = listOf(
        "Pré-aqueça o forno a 180 graus Celsius e unte uma forma para bolo.",
        "Em uma tigela, misture o óleo, açúcar e ovos até obter uma mistura homogênea.",
        "Adicione a farinha de trigo, coco ralado e fermento à mistura e mexa até obter uma massa lisa.",
        "Adicione o leite à mistura e mexa novamente.",
        "Despeje a massa na forma untada e asse por cerca de 35-40 minutos ou até que o bolo esteja dourado e assado por completo.",
        "Retire do forno, deixe esfriar por alguns minutos e sirva."
    )
)

val frangoComAbacaxi = Recipe(
    id = 3,
    name = "Frango com Abacaxi",
    portions = "4",
    calories = 300,
    preparationTime = 30,
    ingredients = listOf(
        Ingredient(
            name = "peitos de frango sem pele e sem osso, cortados em cubos",
            amount = "2",
        ),
        Ingredient(
            name = "abacaxi picado",
            amount = "2",
            unitMeasurement = "xícaras"
        ),
        Ingredient(
            name = "pimentão vermelho picado",
            amount = "1",
        ),
        Ingredient(
            name = "cebola roxa picada",
            amount = "1",
        ),
        Ingredient(
            name = "dentes de alho picados",
            amount = "2",
        ),
        Ingredient(
            name = "azeite",
            amount = "2",
            unitMeasurement = "colheres de sopa"
        ),
        Ingredient(
            name = "amido de milho",
            amount = "1",
            unitMeasurement = "colher de sopa"
        ),
        Ingredient(
            name = "molho de soja",
            amount = "1/4",
            unitMeasurement = "xícara "
        ),
        Ingredient(
            name = "vinagre de maçã",
            amount = "1/4",
            unitMeasurement = "xícara"
        ),
        Ingredient(
            name = "mel",
            amount = "2",
            unitMeasurement = "colheres de sopa"
        ),
        Ingredient(
            name = "sal e pimenta agosto",
            amount = "",
            unitMeasurement = ""
        )
    ),
    instructions = listOf(
        "Em uma frigideira grande, aqueça o azeite em fogo médio-alto. Adicione o frango e cozinhe até que esteja dourado e cozido por completo.",
        "Adicione o abacaxi, pimentão, cebola e alho e cozinhe por mais 3-5 minutos, até que os legumes estejam macios.",
        "Em uma tigela pequena, misture o amido de milho com um pouco de água fria, mexendo bem até que esteja dissolvido. Adicione o molho de soja, vinagre de maçã e mel e misture bem.",
        "Despeje a mistura de molho na frigideira e misture até que o frango e os legumes estejam cobertos pelo molho. Tempere com sal e pimenta a gosto.",
        "Cozinhe por mais 2-3 minutos, até que o molho comece a engrossar e caramelizar. Sirva quente acompanhado de arroz branco ou integral."
    )
)

val guacamole = Recipe(
    id = 4,
    name = "Guacamole",
    portions = "4",
    calories = 170,
    preparationTime = 10,
    ingredients = listOf(
        Ingredient(
            name = "abacate",
            amount = "2",
            unitMeasurement = "",
            observations = listOf("maduros")
        ),
        Ingredient(
            name = "cebola média picada",
            amount = "1/2",
        ),
        Ingredient(
            name = "tomate médio sem sementes e picado",
            amount = "1",
        ),
        Ingredient(
            name = "coentro picado",
            amount = "1/4",
            unitMeasurement = "xícara"
        ),
        Ingredient(
            name = "suco de limão",
            amount = "2",
            unitMeasurement = "colheres de sopa"
        ),
        Ingredient(
            name = "sal e pimenta a gosto"
        ),
    ),
    instructions = listOf(
        "Corte os abacates ao meio e retire o caroço. Em seguida, retire a polpa e coloque em uma tigela média.",
        "Adicione a cebola, tomate e coentro picados ao abacate.",
        "Esprema o suco de limão sobre a mistura de abacate e tempere com sal e pimenta a gosto.",
        "Use um garfo para amassar levemente os ingredientes juntos até que formem uma mistura homogênea. Se preferir, pode deixar alguns pedaços maiores de abacate para uma textura mais rústica.",
        "Sirva imediatamente com tortilhas ou como acompanhamento de outros pratos."
    )
)

val limonadaCremosa = Recipe(
    id = 5,
    name = "Limonada cremosa",
    portions = "4",
    calories = 140,
    preparationTime = 10,
    ingredients = listOf(
        Ingredient(name = "1/2 xícara de suco de limão"),
        Ingredient(name = "1/2 xícara de leite condensado"),
        Ingredient(name = "2 xícaras de água gelada"),
        Ingredient(name = "Cubos de gelo"),
        Ingredient(name = "Fatias de limão para decorar"),
    ),
    instructions = listOf(
        "Em um liquidificador, bata o suco de limão, o leite condensado e a água até ficar homogêneo.",
        "Adicione alguns cubos de gelo e bata novamente até ficar cremoso.",
        "Sirva em copos altos, decorados com fatias de limão."
    )
)

val panquecaDeMacaCaramelizada = Recipe(
    id = 6,
    name = "Panquecas de Maçã Caramelizada",
    portions = "4",
    calories = 260,
    preparationTime = 20,
    ingredients = listOf(
        Ingredient(name = "1 e 1/4 xícaras de farinha de trigo"),
        Ingredient(name = "1 colher de sopa de açúcar"),
        Ingredient(name = "2 colheres de chá de fermento em pó"),
        Ingredient(name = "1/4 colher de chá de sal"),
        Ingredient(name = "1 xícara de leite"),
        Ingredient(name = "1 ovo"),
        Ingredient(name = "2 colheres de sopa de manteiga derretida"),
        Ingredient(name = "1 maçã descascada e cortada em cubos"),
        Ingredient(name = "1 colher de sopa de manteiga"),
        Ingredient(name = "2 colheres de sopa de açúcar mascavo"),
    ),
    instructions = listOf(
        "Em uma tigela grande, misture a farinha, o açúcar, o fermento e o sal.",
        "Em outra tigela, misture o leite, o ovo e a manteiga derretida.",
        "Adicione a mistura de líquidos à mistura de farinha e misture até ficar homogêneo.",
        "Em uma frigideira antiaderente, derreta a manteiga e adicione a maçã cortada em cubos. Cozinhe por 3-4 minutos, ou até que as maçãs estejam caramel"
    )
)

val pudimDeAbacate = Recipe(
    id = 7,
    name = "Pudim de abacate",
    portions = "6",
    calories = 350,
    preparationTime = 10,
    waitingTime = 120,
    ingredients = listOf(
        Ingredient(name = "2 abacates maduros"),
        Ingredient(name = "1 lata de leite condensado"),
        Ingredient(name = "1/2 xícara de leite"),
        Ingredient(name = "1 colher de sopa de suco de limão"),
    ),
    instructions = listOf(
        "Corte os abacates ao meio e retire o caroço. Em seguida, retire a polpa e coloque em um liquidificador.",
        "Adicione o leite condensado e o leite ao liquidificador e bata até obter uma mistura homogênea.",
        "Adicione o suco de limão à mistura e bata novamente.",
        "Despeje a mistura em ramequins ou em uma tigela grande.",
        "Deixe o pudim na geladeira por pelo menos 2 horas para firmar.",
        "Sirva gelado e decorado com fatias de abacate ou chantilly, se desejar."
    )
)

val paoDeBanana = Recipe(
    id = 8,
    name = "Pão de banana",
    portions = "10-12 fatias",
    calories = 220,
    preparationTime = 15,
    waitingTime = 50,
    ingredients = listOf(
        Ingredient(name = "2 bananas maduras amassadas"),
        Ingredient(name = "1/2 xícara de açúcar"),
        Ingredient(name = "1/2 xícara de óleo"),
        Ingredient(name = "2 ovos"),
        Ingredient(name = "1 colher de sopa de fermento em pó"),
        Ingredient(name = "2 xícaras de farinha de trigo"),
        Ingredient(name = "1 colher de chá de canela em pó"),
        Ingredient(name = "1/2 colher de chá de sal"),
    ),
    instructions = listOf(
        "Pré-aqueça o forno a 180 graus Celsius e unte uma forma para pão.",
        "Em uma tigela, misture as bananas amassadas, açúcar, óleo e ovos até obter uma mistura homogênea.",
        "Adicione o fermento, farinha de trigo, canela e sal à mistura e mexa até obter uma massa lisa.",
        "Despeje a massa na forma untada e asse por cerca de 50 minutos ou até que o pão esteja dourado e assado por completo.",
        "Retire do forno, deixe esfriar por alguns minutos e sirva."
    )
)

val saladaDeAbacateEQuinoa = Recipe(
    id = 9,
    name = "Salada de Abacate e Quinoa",
    portions = "4",
    calories = 290,
    preparationTime = 25,
    ingredients = listOf(
        Ingredient(name = "1/2 xícara de quinoa"),
        Ingredient(name = "1 xícara de água"),
        Ingredient(name = "2 abacates maduros"),
        Ingredient(name = "1/2 pepino, sem sementes e picado"),
        Ingredient(name = "1/4 cebola roxa, picada"),
        Ingredient(name = "1/2 pimentão vermelho, sem sementes e picado"),
        Ingredient(name = "1/4 xícara de coentro fresco, picado"),
        Ingredient(name = "2 colheres de sopa de azeite"),
        Ingredient(name = "Suco de 1 limão"),
        Ingredient(name = "Sal e pimenta a gosto"),
    ),
    instructions = listOf(
        "Lave a quinoa em água corrente. Em uma panela, adicione a quinoa e a água e leve para ferver em fogo médio. Reduza o fogo para baixo, tampe a panela e cozinhe por cerca de 15-20 minutos, até que a quinoa esteja macia e toda a água tenha sido absorvida. Reserve.",
        "Enquanto a quinoa cozinha, corte os abacates ao meio e retire o caroço. Retire a polpa e corte em cubos médios.",
        "Em uma tigela grande, misture a quinoa cozida com os cubos de abacate, pepino, cebola roxa, pimentão vermelho e coentro.",
        "Adicione o azeite, suco de limão, sal e pimenta a gosto e misture bem.",
        "Sirva imediatamente como uma salada refrescante e saudável."
    ),
    observations = listOf("Esta receita é vegetariana e pode ser facilmente adaptada para veganos e intolerantes à lactose, basta verificar os rótulos dos ingredientes utilizados.")
)

val saladaDeAbacaxiCamaraoEQuinoa = Recipe(
    id = 10,
    name = "Salada de Abacaxi, Camarão e Quinoa",
    portions = "4",
    calories = 300,
    preparationTime = 25,
    ingredients = listOf(
        Ingredient(name = "1 xícara de quinoa"),
        Ingredient(name = "2 xícaras de água"),
        Ingredient(name = "2 xícaras de camarão cozido e descascado"),
        Ingredient(name = "1/2 abacaxi picado"),
        Ingredient(name = "1/2 pimentão amarelo picado"),
        Ingredient(name = "1/2 cebola roxa picada"),
        Ingredient(name = "1/2 xícara de coentro fresco picado"),
        Ingredient(name = "1/4 xícara de azeite"),
        Ingredient(name = "1/4 xícara de suco de limão"),
        Ingredient(name = "Sal e pimenta a gosto"),
    ),
    instructions = listOf(
        "Em uma panela, adicione a quinoa e a água e leve ao fogo médio. Deixe ferver, reduza o fogo para baixo e cozinhe por cerca de 15 minutos ou até que a água tenha sido absorvida e a quinoa esteja macia. Reserve.",
        "Em uma tigela grande, misture o camarão cozido, abacaxi, pimentão, cebola e coentro.",
        "Em outra tigela pequena, misture o azeite, suco de limão, sal e pimenta.",
        "Adicione a quinoa à mistura de camarão e legumes, e em seguida despeje o molho por cima. Misture tudo até que esteja bem incorporado.",
        "Sirva a salada fria, decorada com folhas de coentro frescas."
    )
)

val saladaDeFrutasComLaranjaEMel = Recipe(
    id = 11,
    name = "Salada de Frutas com Laranja e Mel",
    portions = "4",
    calories = 120,
    preparationTime = 15,
    waitingTime = 60,
    ingredients = listOf(
        Ingredient(name = "2 laranjas grandes descascadas e cortadas em cubos"),
        Ingredient(name = "2 bananas maduras cortadas em rodelas"),
        Ingredient(name = "1 maçã cortada em cubos"),
        Ingredient(name = "1/2 xícara de uvas cortadas ao meio"),
        Ingredient(name = "2 colheres de sopa de mel"),
        Ingredient(name = "1/4 xícara de suco de laranja"),
    ),
    instructions = listOf(
        "Coloque as frutas em uma tigela grande e misture delicadamente.",
        "Em uma tigela pequena, misture o mel e o suco de laranja para fazer o molho.",
        "Despeje o molho sobre as frutas e misture delicadamente.",
        "Cubra a tigela com papel filme e leve à geladeira por pelo menos 1 hora antes de servir."
    )
)

val saladaDeFrutasComMamaoEHortela = Recipe(
    id = 12,
    name = "Salada de frutas com mamão e hortelã",
    portions = "6",
    calories = 130,
    preparationTime = 20,
    ingredients = listOf(
        Ingredient(name = "1 mamão papaia maduro"),
        Ingredient(name = "1/2 abacaxi cortado em cubos"),
        Ingredient(name = "2 mangas cortadas em cubos"),
        Ingredient(name = "1 cacho de uvas sem sementes"),
        Ingredient(name = "1/2 xícara de suco de laranja"),
        Ingredient(name = "1/4 xícara de folhas de hortelã fresca picadas"),
        Ingredient(name = "1 colher de sopa de açúcar (opcional)"),
    ),
    instructions = listOf(
        "Descasque e retire as sementes do mamão, corte em cubos e coloque em uma tigela grande.",
        "Adicione o abacaxi, as mangas e as uvas à tigela.",
        "Em outra tigela, misture o suco de laranja, as folhas de hortelã e o açúcar (se estiver usando). Despeje sobre a salada de frutas e misture delicadamente.",
        "Sirva imediatamente ou mantenha refrigerado até a hora de servir."
    )
)

val saladaDeMelanciaComFetaEManjericao = Recipe(
    id = 13,
    name = "Salada de Melancia com Feta e Manjericão",
    portions = "4",
    calories = 170,
    preparationTime = 15,
    ingredients = listOf(
        Ingredient(name = "1/2 melancia pequena, cortada em cubos"),
        Ingredient(name = "100 g de queijo feta em cubos"),
        Ingredient(name = "1/4 xícara de folhas de manjericão fresco picado"),
        Ingredient(name = "2 colheres de sopa de azeite de oliva"),
        Ingredient(name = "1 colher de sopa de suco de limão"),
        Ingredient(name = "Sal e pimenta a gosto"),
    ),
    instructions = listOf(
        "Coloque a melancia, queijo feta e manjericão em uma tigela grande e misture delicadamente.",
        "Em uma tigela pequena, misture o azeite de oliva, suco de limão, sal e pimenta a gosto para fazer o molho.",
        "Adicione o molho à salada e misture delicadamente.",
        "Sirva a salada imediatamente."
    )
)

val saladaDeQuinoaComMangaEAbacate = Recipe(
    id = 14,
    name = "Salada de Quinoa com Manga e Abacate",
    portions = "4",
    calories = 310,
    preparationTime = 15,
    waitingTime = 15,
    ingredients = listOf(
        Ingredient(name = "1 xícara de quinoa"),
        Ingredient(name = "2 xícaras de água"),
        Ingredient(name = "1 manga madura, descascada e cortada em cubos"),
        Ingredient(name = "1 abacate maduro, descascado e cortado em cubos"),
        Ingredient(name = "1/2 cebola roxa, cortada em cubos"),
        Ingredient(name = "1/2 xícara de coentro fresco picado"),
        Ingredient(name = "1 colher de sopa de azeite de oliva"),
        Ingredient(name = "1 colher de sopa de suco de limão"),
        Ingredient(name = "Sal e pimenta a gosto"),
    ),
    instructions = listOf(
        "Enxágue a quinoa em água fria e coloque-a em uma panela com a água. Leve ao fogo e deixe ferver.",
        "Abaixe o fogo e deixe a quinoa cozinhar por cerca de 15 minutos ou até que os grãos estejam macios e toda a água tenha sido absorvida. Reserve.",
        "Em uma tigela, misture a manga, abacate, cebola e coentro.",
        "Adicione a quinoa cozida à tigela e misture delicadamente.",
        "Em uma tigela pequena, misture o azeite de oliva, suco de limão, sal e pimenta a gosto para fazer o molho.",
        "Adicione o molho à salada e misture delicadamente.",
        "Sirva a salada em temperatura ambiente ou fria."
    )
)

val saladaDeUvaComQueijoFetaENoses = Recipe(
    id = 15,
    name = "Salada de uva com queijo feta e nozes",
    portions = "4",
    calories = 220,
    preparationTime = 15,
    ingredients = listOf(
        Ingredient(name = "2 xícaras de uvas sem sementes, cortadas ao meio"),
        Ingredient(name = "2 xícaras de alface romana picada"),
        Ingredient(name = "1/2 xícara de queijo feta esfarelado"),
        Ingredient(name = "1/2 xícara de nozes picadas"),
        Ingredient(name = "2 colheres de sopa de azeite de oliva"),
        Ingredient(name = "1 colher de sopa de vinagre balsâmico"),
        Ingredient(name = "Sal e pimenta-do-reino a gosto"),
    ),
    instructions = listOf(
        "Em uma tigela grande, misture as uvas, a alface, o queijo feta e as nozes.",
        "Em uma tigela pequena, misture o azeite, o vinagre balsâmico, o sal e a pimenta-do-reino.",
        "Despeje o molho sobre a salada de uva e misture bem.",
        "Sirva imediatamente."
    )
)

val salmaoGrelhadoComMolhoDeLaranja = Recipe(
    id = 16,
    name = "Salmão Grelhado com Molho de Laranja",
    portions = "4",
    calories = 350,
    preparationTime = 20,
    ingredients = listOf(
        Ingredient(name = "4 filés de salmão"),
        Ingredient(name = "1 laranja grande (suco e raspas)"),
        Ingredient(name = "1/4 xícara de azeite de oliva"),
        Ingredient(name = "1 colher de sopa de mel"),
        Ingredient(name = "1 colher de chá de mostarda dijon"),
        Ingredient(name = "Sal e pimenta a gosto"),
    ),
    instructions = listOf(
        "Pré-aqueça uma grelha em fogo médio-alto.",
        "Tempere os filés de salmão com sal e pimenta.",
        "Em uma tigela pequena, misture o suco de laranja, as raspas de laranja, azeite de oliva, mel, mostarda dijon e sal e pimenta a gosto para fazer o molho.",
        "Coloque os filés de salmão na grelha e grelhe por cerca de 5 minutos de cada lado, ou até que estejam cozidos.",
        "Sirva o salmão com o molho de laranja por cima."
    )
)

val smoothieDeAbacaxiComHortela = Recipe(
    id = 17,
    name = "Smoothie de Abacaxi e Hortelã",
    portions = "2",
    calories = 200,
    preparationTime = 10,
    ingredients = listOf(
        Ingredient(name = "2 xícaras de abacaxi picado"),
        Ingredient(name = "1/2 xícara de iogurte natural"),
        Ingredient(name = "1/2 xícara de leite de amêndoa"),
        Ingredient(name = "1 colher de sopa de mel"),
        Ingredient(name = "1/2 xícara de folhas de hortelã frescas"),
        Ingredient(name = "Gelo a gosto"),
    ),
    instructions = listOf(
        "Adicione todos os ingredientes em um liquidificador e misture até que fique homogêneo.",
        "Adicione gelo a gosto e misture novamente até que o smoothie esteja na consistência desejada.",
        "Sirva imediatamente em copos altos decorados com folhas de hortelã frescas."
    )
)

val smoothieDeMangaEIogurte = Recipe(
    id = 18,
    name = "Smoothie de Manga e Iogurte",
    portions = "2",
    calories = 180,
    preparationTime = 10,
    ingredients = listOf(
        Ingredient(name = "2 mangas maduras"),
        Ingredient(name = "1 xícara de iogurte natural"),
        Ingredient(name = "1/2 xícara de leite"),
        Ingredient(name = "1 colher de sopa de mel"),
        Ingredient(name = "1 colher de chá de suco de limão"),
    ),
    instructions = listOf(
        "Descasque as mangas e retire o caroço.",
        "Corte a polpa da manga em pedaços e coloque no liquidificador.",
        "Adicione o iogurte, leite, mel e suco de limão no liquidificador e misture até obter uma mistura homogênea e cremosa.",
        "Despeje o smoothie em um copo, adicione cubos de gelo se desejar e sirva."
    )
)

val smoothieDeMelanciaComHortela = Recipe(
    id = 19,
    name = "Smoothie de Melancia com Hortelã",
    portions = "2",
    calories = 70,
    preparationTime = 10,
    ingredients = listOf(
        Ingredient(name = "2 xícaras de melancia cortada em cubos"),
        Ingredient(name = "1/2 xícara de suco de laranja"),
        Ingredient(name = "1 colher de sopa de suco de limão"),
        Ingredient(name = "1/4 xícara de folhas de hortelã fresca"),
        Ingredient(name = "1/2 xícara de gelo"),
    ),
    instructions = listOf(
        "Coloque a melancia, suco de laranja, suco de limão e hortelã fresca em um liquidificador e misture até ficar homogêneo.",
        "Adicione o gelo e misture novamente até quebrar completamente o gelo.",
        "Sirva imediatamente."
    )
)

val smoothieDeUvaEBanana = Recipe(
    id = 20,
    name = "Smoothie de uva e banana",
    portions = "2",
    calories = 130,
    preparationTime = 5,
    ingredients = listOf(
        Ingredient(name = "1 xícara de uvas sem sementes"),
        Ingredient(name = "1 banana média"),
        Ingredient(name = "1/2 xícara de iogurte natural"),
        Ingredient(name = "1/2 xícara de leite desnatado"),
        Ingredient(name = "1 colher de chá de mel (opcional)"),
        Ingredient(name = "Cubos de gelo"),
    ),
    instructions = listOf(
        "Coloque as uvas, a banana, o iogurte, o leite e o mel (se estiver usando) no liquidificador e bata até ficar homogêneo.",
        "Adicione alguns cubos de gelo e bata novamente até ficar cremoso.",
        "Sirva imediatamente em um copo alto."
    )
)

val sorveteDeBanana = Recipe(
    id = 21,
    name = "Sorvete de banana",
    portions = "4",
    calories = 120,
    preparationTime = 5,
    waitingTime = 150,
    ingredients = listOf(
        Ingredient(name = "4 bananas maduras congeladas"),
        Ingredient(name = "1/2 xícara de leite de coco"),
        Ingredient(name = "1 colher de chá de extrato de baunilha"),
    ),
    instructions = listOf(
        "Corte as bananas congeladas em pedaços pequenos e coloque-as no processador de alimentos.",
        "Adicione o leite de coco e o extrato de baunilha e processe até obter uma mistura cremosa e homogênea.",
        "Despeje o sorvete em um recipiente com tampa e leve ao freezer por cerca de 2-3 horas ou até que esteja firme.",
        "Retire do freezer, deixe descongelar um pouco e sirva."
    )
)

val vitaminaDeMamaoEBanana = Recipe(
    id = 22,
    name = "Vitamina de mamão e banana",
    portions = "2",
    calories = 150,
    preparationTime = 5,
    ingredients = listOf(
        Ingredient(name = "1/2 mamão papaia maduro"),
        Ingredient(name = "1 banana média"),
        Ingredient(name = "1 xícara de leite desnatado"),
        Ingredient(name = "1 colher de chá de mel (opcional)"),
        Ingredient(name = "Cubos de gelo"),
    ),
    instructions = listOf(
        "Descasque e retire as sementes do mamão e corte em cubos. Descasque a banana e corte em rodelas.",
        "Coloque o mamão, a banana, o leite e o mel (se estiver usando) no liquidificador e bata até ficar homogêneo.",
        "Adicione alguns cubos de gelo e bata novamente até ficar cremoso.",
        "Sirva imediatamente em um copo alto."
    )
)

val boloDeMaca = Recipe(
    id = 23,
    name = "Bolo de maça",
    portions = "12 fatias",
    calories = 300,
    preparationTime = 75,
    ingredients = listOf(
        Ingredient(name = "2 xícaras de farinha de trigo"),
        Ingredient(name = "1 e 1/2 xícaras de açúcar"),
        Ingredient(name = "1 colher de sopa de fermento em pó"),
        Ingredient(name = "1 colher de chá de canela em pó"),
        Ingredient(name = "1/2 colher de chá de noz-moscada em pó"),
        Ingredient(name = "1/2 colher de chá de sal"),
        Ingredient(name = "3 ovos"),
        Ingredient(name = "3/4 xícara de óleo de canola"),
        Ingredient(name = "1/4 xícara de suco de laranja"),
        Ingredient(name = "1 colher de sopa de casca de laranja ralada"),
        Ingredient(name = "2 xícaras de maçãs descascadas e picadas"),
        Ingredient(name = "Açúcar de confeiteiro para decorar (opcional)"),
    ),
    instructions = listOf(
        "Preaqueça o forno a 180 graus Celsius. Unte uma forma de bolo com manteiga e farinha de trigo.",
        "Em uma tigela grande, misture a farinha de trigo, o açúcar, o fermento, a canela, a noz-moscada e o sal.",
        "Em outra tigela, bata os ovos com o óleo, o suco de laranja e a casca de laranja ralada.",
        "Adicione a mistura de ovos à mistura de farinha e mexa até ficar homogêneo. Em seguida, misture as maçãs picadas.",
        "Despeje a massa na forma de bolo preparada e leve ao forno por cerca de 50 a 60 minutos, ou até que um palito inserido no centro do bolo saia limpo.",
        "Deixe o bolo esfriar por alguns minutos antes de desenformar. Polvilhe açúcar de confeiteiro por cima, se desejar.",
        "Sirva em fatias."
    )
)

val recipes = listOf(
    boloDeMaca,
    vitaminaDeMamaoEBanana,
    sorveteDeBanana,
    smoothieDeUvaEBanana,
    smoothieDeMelanciaComHortela,
    smoothieDeMangaEIogurte,
    smoothieDeAbacaxiComHortela,
    salmaoGrelhadoComMolhoDeLaranja,
    saladaDeUvaComQueijoFetaENoses,
    saladaDeQuinoaComMangaEAbacate,
    saladaDeMelanciaComFetaEManjericao,
    saladaDeFrutasComMamaoEHortela,
    saladaDeFrutasComLaranjaEMel,
    saladaDeAbacaxiCamaraoEQuinoa,
    saladaDeAbacateEQuinoa,
    paoDeBanana,
    pudimDeAbacate,
    panquecaDeMacaCaramelizada,
    limonadaCremosa,
    guacamole,
    frangoComAbacaxi,
    boloDeCoco,
    arrozDoceDeCoco
)

val relationFruitRecipe = listOf(
    Pair(boloDeMaca.id, apple.id),
    Pair(vitaminaDeMamaoEBanana.id, banana.id),
    Pair(vitaminaDeMamaoEBanana.id, papaya.id),
    Pair(sorveteDeBanana.id, banana.id),
    Pair(smoothieDeUvaEBanana.id, grape.id),
    Pair(smoothieDeUvaEBanana.id, banana.id),
    Pair(smoothieDeMelanciaComHortela.id, watermelon.id),
    Pair(smoothieDeMangaEIogurte.id, mango.id),
    Pair(smoothieDeAbacaxiComHortela.id, pineapple.id),
    Pair(salmaoGrelhadoComMolhoDeLaranja.id, orange.id),
    Pair(saladaDeUvaComQueijoFetaENoses.id, grape.id),
    Pair(saladaDeQuinoaComMangaEAbacate.id, mango.id),
    Pair(saladaDeQuinoaComMangaEAbacate.id, avocado.id),
    Pair(saladaDeMelanciaComFetaEManjericao.id, watermelon.id),
    Pair(saladaDeFrutasComMamaoEHortela.id, papaya.id),
    Pair(saladaDeFrutasComLaranjaEMel.id, orange.id),
    Pair(saladaDeAbacaxiCamaraoEQuinoa.id, pineapple.id),
    Pair(saladaDeAbacateEQuinoa.id, avocado.id),
    Pair(paoDeBanana.id, banana.id),
    Pair(pudimDeAbacate.id, avocado.id),
    Pair(panquecaDeMacaCaramelizada.id, apple.id),
    Pair(limonadaCremosa.id, lemon.id),
    Pair(guacamole.id, avocado.id),
    Pair(frangoComAbacaxi.id, pineapple.id),
    Pair(boloDeCoco.id, coconut.id),
    Pair(arrozDoceDeCoco.id, coconut.id),
)