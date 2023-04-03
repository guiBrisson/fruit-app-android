package me.brisson.domain

import me.brisson.domain.model.Fruit
import me.brisson.domain.model.Month

val january = Month(name = "Janeiro", number = 1)
val february = Month(name = "Fevereiro", number = 2)
val march = Month(name = "Março", number = 3)
val april = Month(name = "Abril", number = 4)
val may = Month(name = "Maio", number = 5)
val june = Month(name = "Junho", number = 6)
val july = Month(name = "Julho", number = 7)
val august = Month(name = "Agosto", number = 8)
val september =Month(name = "Setembro", number = 9)
val october = Month(name = "Outrubro", number = 10)
val november = Month(name = "Novembro", number = 11)
val december = Month(name = "Dezembro", number = 12)

val months = listOf(
    january, february, march, april, may, june, july, august, september, october, november, december
)


val avocado = Fruit(
    id = 1,
    name = "Abacate",
    imageUrl = "https://images.unsplash.com/photo-1523049673857-eb18f1d7b578?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1075&q=80",
    summary = "Fruta com alto teor de gordura saudável, fonte de vitamina E e ácido oleico. Pode ser consumida in natura ou em preparações.",
    months = listOf(january, february, march, april, may, september),
    paragraphs = listOf(
        "O abacate é uma fruta originária da América Central e do Sul, mas é amplamente cultivado em todo o mundo. Ele é conhecido por sua textura cremosa e sabor suave e é uma fonte rica de nutrientes essenciais. O abacate contém gorduras saudáveis, como o ácido oleico, que é encontrado no azeite de oliva e é benéfico para a saúde do coração. Ele também é rico em fibras, vitaminas C, E e K, bem como em potássio e folato.",
        "O abacate é versátil na cozinha e pode ser usado em uma variedade de pratos, desde guacamole até smoothies e saladas. Além disso, ele pode ser consumido tanto maduro quanto verde e ainda assim oferecer muitos benefícios à saúde. Embora seja frequentemente visto como uma fruta calórica, os nutrientes encontrados no abacate podem ajudar a controlar o apetite e a manter a saciedade por mais tempo.",
        "Além de ser uma fonte nutricionalmente rica de alimentos, o abacate também tem benefícios para a saúde da pele e do cabelo. Seu óleo é rico em ácido oleico, ácido linoleico e vitamina E, o que o torna um ingrediente popular em muitos produtos de cuidados pessoais. O abacate também contém antioxidantes que ajudam a reduzir o estresse oxidativo nas células, reduzindo assim o risco de danos celulares e envelhecimento precoce."
    )
)

val pineapple = Fruit(
    id = 2,
    name = "Abacaxi",
    imageUrl = "https://images.unsplash.com/photo-1589820296156-2454bb8a6ad1?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80",
    summary = "Fruta tropical doce e suculenta, rica em vitamina C e bromelina, uma enzima que ajuda na digestão.",
    months = listOf(january, february, june),
    paragraphs = listOf(
        "O abacaxi é uma fruta tropical que é cultivada em muitos países ao redor do mundo, incluindo Brasil, Tailândia e Filipinas. Ele é conhecido por sua polpa suculenta, sabor doce e azedo, além de ser uma excelente fonte de nutrientes. O abacaxi é rico em vitamina C, que ajuda a fortalecer o sistema imunológico e pode ajudar na absorção de ferro. Além disso, a fruta também contém bromelina, uma enzima que ajuda a digerir proteínas e tem propriedades anti-inflamatórias.",
        "O abacaxi pode ser consumido fresco ou enlatado, e é frequentemente usado em sobremesas, sucos e coquetéis. Além disso, a fruta também pode ser adicionada a saladas, pratos de carne e frutos do mar para adicionar um toque tropical. O abacaxi é uma excelente fonte de hidratação e pode ajudar a manter o corpo hidratado durante o tempo quente.",
        "Além de seu sabor delicioso, o abacaxi também tem muitos benefícios para a saúde. A bromelina encontrada no abacaxi pode ajudar a reduzir a inflamação e a dor em condições como artrite e lesões esportivas. Além disso, a fruta é uma fonte natural de antioxidantes, que ajudam a combater o estresse oxidativo no corpo e podem ajudar a reduzir o risco de doenças crônicas, como doenças cardíacas e câncer."
    )
)

val banana = Fruit(
    id = 3,
    name = "Banana",
    imageUrl = "https://images.unsplash.com/photo-1571771894821-ce9b6c11b08e?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=880&q=80",
    summary = "Fruta doce e energética, rica em potássio e carboidratos. Pode ser consumida in natura ou em preparações.",
    months = listOf(january, february, march, april, may, june, july, august, september, october, november, december),
    paragraphs = listOf(
        "A banana é uma das frutas mais populares em todo o mundo, sendo cultivada em muitos países tropicais. Ela é uma excelente fonte de nutrientes, incluindo vitaminas B6 e C, potássio, fibras e carboidratos. A banana é uma fruta muito versátil, podendo ser consumida crua, cozida ou assada, e é frequentemente usada em sobremesas, smoothies e vitaminas.",
        "A banana é um alimento de fácil digestão e é uma ótima opção para quem precisa de uma fonte rápida de energia. A fruta também é rica em fibras solúveis, que ajudam a reduzir o colesterol no sangue e a manter a saúde do trato intestinal. Além disso, a banana é uma fonte natural de carboidratos, o que a torna uma opção ideal para pessoas que praticam atividades físicas intensas.",
        "Além de seus benefícios nutricionais, a banana também é conhecida por seus benefícios para a saúde. O potássio encontrado na banana ajuda a manter a pressão arterial saudável e a função do coração. A fruta também contém compostos antioxidantes, como catequinas e dopamina, que ajudam a proteger o corpo contra o estresse oxidativo e podem ajudar a reduzir o risco de doenças crônicas, como doenças cardíacas e câncer.",
        "Por fim, a banana é uma ótima opção para lanches saudáveis, já que é fácil de transportar e não requer preparação. Ela pode ser adicionada a outros alimentos, como iogurte, cereais ou manteiga de amendoim, para um lanche nutritivo e saboroso."
    )
)

val coconut = Fruit(
    id = 3,
    name = "Coco",
    imageUrl = "https://images.unsplash.com/photo-1560769680-ba2f3767c785?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=764&q=80",
    summary = "O coco é uma fruta tropical muito apreciada por sua água doce e pela polpa branca e carnuda. É uma fruta versátil, que pode ser consumida fresca, seca, ralada ou em forma de leite.",
    months = listOf(january, february, march, april, may, june, july, august, september, october, november, december),
    paragraphs = listOf(
        "O coco é uma fruta tropical originária da região do sudeste asiático, mas atualmente é cultivada em muitos países ao redor do mundo. Ele é conhecido por sua polpa branca e sabor doce, e é uma excelente fonte de nutrientes. O coco é rico em fibras, vitaminas C e E, ácido fólico, potássio e magnésio, além de ser uma ótima fonte de gorduras saudáveis.",
        "O coco pode ser consumido fresco ou processado em diferentes formas, como leite de coco, óleo de coco, açúcar de coco e farinha de coco. O leite de coco é um ingrediente comum em muitas receitas asiáticas, e pode ser usado para cozinhar arroz, fazer sopas ou molhos. O óleo de coco é usado em muitas receitas de assados e frituras, e também tem sido associado a benefícios para a saúde, como aumento do colesterol bom (HDL) e redução do colesterol ruim (LDL).",
        "Além de seus benefícios nutricionais, o coco também tem muitos benefícios para a saúde. A gordura encontrada no coco é composta principalmente de ácidos graxos de cadeia média, que são facilmente metabolizados pelo corpo e podem ajudar na perda de peso. Além disso, a fruta é rica em antioxidantes, que ajudam a combater o estresse oxidativo no corpo e podem ajudar a reduzir o risco de doenças crônicas, como doenças cardíacas e câncer.",
        "Por fim, o coco também tem propriedades antimicrobianas e antifúngicas, o que o torna um remédio natural para muitas condições de pele, como acne e dermatite. O óleo de coco pode ser usado como um hidratante natural para a pele e o cabelo, e o coco também é um ingrediente comum em muitos produtos de cuidados pessoais, como xampus e condicionadores."
    )
)

val orange = Fruit(
    id = 4,
    name = "Laranja",
    imageUrl = "https://images.unsplash.com/photo-1592187270271-9a4b84faa228?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80",
    summary = "Uma fruta cítrica popular e comum, com casca laranja brilhante e polpa suculenta e doce ou azeda. É uma excelente fonte de vitamina C e também contém folato e potássio.",
    months = listOf(june, july, august, september, december, january),
    paragraphs = listOf(
        "A laranja é uma das frutas mais populares do mundo, sendo originária do sudeste asiático. Ela é uma excelente fonte de vitamina C, que ajuda a aumentar a imunidade e proteger o corpo contra doenças. Além disso, a laranja é rica em fibras, potássio, ácido fólico e antioxidantes, tornando-se um alimento extremamente saudável.",
        "A laranja é uma fruta versátil, podendo ser consumida fresca, em sucos ou como ingrediente em muitas receitas, incluindo saladas, sobremesas e pratos salgados. O suco de laranja é uma fonte rápida e fácil de nutrientes, mas é importante lembrar que a ingestão de suco de frutas deve ser moderada, pois pode conter altos níveis de açúcar.",
        "Além de seus benefícios nutricionais, a laranja tem muitos benefícios para a saúde. Os antioxidantes encontrados na laranja ajudam a reduzir o estresse oxidativo no corpo, o que pode levar a doenças crônicas, como doenças cardíacas e câncer. A fruta também é rica em hesperidina, um flavonoide que ajuda a reduzir a inflamação e melhorar a saúde do coração.",
        "Outro benefício importante da laranja é seu teor de fibras. As fibras encontradas na laranja ajudam a manter o trato intestinal saudável, reduzem o risco de doenças gastrointestinais e promovem a sensação de saciedade, o que pode ajudar na perda de peso. Além disso, a laranja contém pectina, uma fibra solúvel que ajuda a reduzir o colesterol no sangue.",
        "Por fim, a laranja é uma fruta fácil de encontrar e muito acessível, o que a torna uma excelente opção para quem procura uma fonte nutritiva de vitamina C e outros nutrientes importantes. É importante escolher laranjas maduras e armazená-las em local fresco e seco para prolongar sua vida útil."
    )
)

val lemon = Fruit(
    id = 4,
    name = "Limão",
    imageUrl = "https://images.unsplash.com/photo-1582287104445-6754664dbdb2?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80",
    summary = "Outra fruta cítrica comum, com casca amarela brilhante e polpa ácida e suculenta. É rica em vitamina C, flavonóides e outros antioxidantes.",
    months = listOf(may, june, july, august, september, january, february, march),
    paragraphs = listOf(
        "O limão é uma fruta cítrica popular em todo o mundo, originária do sudeste da Ásia. Ele é conhecido por seu sabor ácido e picante, e é amplamente utilizado na culinária, em sucos, temperos e sobremesas. Além disso, o limão é uma excelente fonte de vitamina C e contém muitos outros nutrientes importantes, incluindo antioxidantes, flavonoides e compostos vegetais.",
        "A vitamina C encontrada no limão ajuda a aumentar a imunidade, protegendo o corpo contra doenças e infecções. Além disso, os antioxidantes e compostos vegetais do limão têm propriedades anti-inflamatórias e podem ajudar a reduzir o risco de doenças crônicas, como doenças cardíacas e câncer.",
        "O limão também é conhecido por seus benefícios para a digestão. A acidez do limão ajuda a quebrar os alimentos e facilitar a digestão, e também pode ajudar a reduzir a azia e o refluxo ácido. Além disso, o limão contém fibras solúveis e insolúveis, que ajudam a manter o trato intestinal saudável e regular.",
        "Outro benefício importante do limão é seu potencial para ajudar na perda de peso. Os compostos vegetais encontrados no limão, como os polifenóis, foram associados à redução da gordura corporal e do peso em estudos em animais. Além disso, o limão pode ajudar a controlar os níveis de açúcar no sangue e a reduzir a resistência à insulina, o que pode ser benéfico para pessoas com diabetes.",
        "Por fim, o limão é uma fruta versátil e pode ser facilmente incorporado à dieta. Ele pode ser consumido fresco, em sucos, chás ou como ingrediente em muitas receitas, incluindo saladas, sobremesas e pratos salgados. No entanto, é importante lembrar que o limão é altamente ácido e pode causar irritação em algumas pessoas, especialmente se consumido em grandes quantidades."
    )
)

val papaya = Fruit(
    id = 5,
    name = "Mamão",
    imageUrl = "https://images.unsplash.com/photo-1517282009859-f000ec3b26fe?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80",
    summary = "Uma fruta tropical com casca fina e lisa e polpa macia e doce. É rica em vitamina C, carotenoides e enzimas digestivas.",
    months = listOf(january, february, march, july, august, september, october, november),
    paragraphs = listOf(
        "O mamão é uma fruta tropical que é cultivada em todo o mundo. É conhecido por seu sabor doce e sua textura macia e cremosa, e é frequentemente consumido fresco ou adicionado a saladas de frutas, smoothies e sobremesas. O mamão é uma excelente fonte de nutrientes, incluindo vitamina C, vitamina A, folato, potássio e fibras dietéticas.",
        "A vitamina C presente no mamão ajuda a aumentar a imunidade e a proteger o corpo contra doenças e infecções. Já a vitamina A é importante para a saúde dos olhos, pele e cabelos. O folato é essencial para a produção de células sanguíneas e para o desenvolvimento fetal saudável durante a gravidez. O potássio é importante para a saúde do coração e do sistema nervoso, enquanto as fibras ajudam a manter o trato intestinal saudável e regular.",
        "Além disso, o mamão contém uma enzima chamada papaína, que ajuda na digestão de proteínas. A papaína pode ajudar a reduzir a inflamação e melhorar a digestão, tornando o mamão uma excelente opção para pessoas com problemas digestivos. O mamão também contém compostos vegetais antioxidantes, como os carotenoides, que podem ajudar a reduzir o risco de doenças crônicas, como doenças cardíacas e câncer.",
        "O mamão pode ser facilmente incorporado à dieta de várias maneiras, seja consumido fresco, em saladas de frutas, smoothies ou adicionado a pratos salgados, como saladas e pratos de peixe. É importante lembrar que o mamão contém uma enzima chamada papaína, que pode causar reações alérgicas em algumas pessoas, portanto, é sempre recomendável consultar um médico antes de incluí-lo na dieta, especialmente se você tiver alguma alergia alimentar conhecida."
    )
)

val mango = Fruit(
    id = 6,
    name = "Manga",
    imageUrl = "https://images.unsplash.com/photo-1604256913753-eef2d1d8ca21?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1171&q=80",
    summary = "Uma fruta tropical doce e suculenta, com casca fina e lisa e polpa macia e fibrosa. É uma excelente fonte de vitamina C e carotenoides.",
    months = listOf(october, november, december, january, february),
    paragraphs = listOf(
        "A manga é uma fruta tropical que é popular em todo o mundo por seu sabor doce e suculento. Ela é rica em nutrientes, incluindo vitamina C, vitamina A, vitamina K, folato, potássio e fibras. A vitamina C presente na manga ajuda a aumentar a imunidade e a proteger o corpo contra doenças e infecções, enquanto a vitamina A é importante para a saúde dos olhos, pele e cabelos. A vitamina K ajuda na coagulação do sangue e o folato é essencial para a produção de células sanguíneas e para o desenvolvimento fetal saudável durante a gravidez. O potássio é importante para a saúde do coração e do sistema nervoso, enquanto as fibras ajudam a manter o trato intestinal saudável e regular.",
        "Além de ser rica em nutrientes, a manga também contém compostos vegetais antioxidantes, como os carotenoides e os polifenóis. Esses compostos podem ajudar a reduzir o risco de doenças crônicas, como doenças cardíacas e câncer, e também podem ter efeitos anti-inflamatórios no corpo. Além disso, a manga contém enzimas digestivas naturais, como a amilase e a lipase, que ajudam na digestão e na absorção de nutrientes.",
        "A manga pode ser consumida fresca, em saladas de frutas, smoothies e sobremesas, além de ser adicionada a pratos salgados, como saladas e carnes. Ela também é utilizada na preparação de molhos, chutneys e conservas. No entanto, é importante lembrar que a manga contém uma grande quantidade de açúcar natural, portanto, deve ser consumida com moderação por pessoas que precisam controlar a ingestão de açúcar, como diabéticos. Além disso, algumas pessoas podem ter alergias à manga, portanto, é sempre recomendável consultar um médico antes de incluí-la na dieta, especialmente se você tiver alguma alergia alimentar conhecida."
    )
)

val apple = Fruit(
    id = 6,
    name = "Maçã",
    imageUrl = "https://images.unsplash.com/photo-1579613832125-5d34a13ffe2a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80",
    summary = "Uma fruta redonda e crocante com casca fina e variando de verde a vermelho, com polpa branca e doce ou levemente ácida. É uma boa fonte de fibra, vitamina C e antioxidantes.",
    months = listOf(january, february, march, april, may, july, august, september, october, november),
    paragraphs = listOf(
        "A maçã é uma fruta popular e saudável que é consumida em todo o mundo. Ela é rica em nutrientes, incluindo fibras solúveis e insolúveis, vitamina C, vitamina K e potássio. As fibras presentes na maçã ajudam a manter a saúde do trato intestinal, promovendo a regularidade do intestino e prevenindo a constipação. A vitamina C é um antioxidante que ajuda a proteger as células do corpo contra danos causados pelos radicais livres, enquanto a vitamina K é importante para a coagulação sanguínea. O potássio é importante para a saúde do coração e do sistema nervoso.",
        "Além de ser rica em nutrientes, a maçã contém compostos vegetais antioxidantes, como os flavonoides e os ácidos fenólicos, que ajudam a proteger o corpo contra doenças crônicas, como doenças cardíacas e câncer. Estudos também sugerem que os compostos presentes na maçã podem ajudar a controlar o açúcar no sangue e melhorar a saúde cerebral.",
        "A maçã pode ser consumida fresca, em saladas de frutas, assada, cozida, em molhos, sucos e sobremesas. Ela também é utilizada como ingrediente em diversos pratos salgados, como saladas, sopas e guisados. É importante lembrar que a casca da maçã contém muitos nutrientes e antioxidantes, portanto, é recomendável consumi-la juntamente com a polpa sempre que possível. No entanto, algumas pessoas podem ter alergias à maçã ou intolerância à frutose, portanto, é sempre recomendável consultar um médico antes de incluí-la na dieta, especialmente se você tiver alguma alergia alimentar conhecida."
    )
)

val watermelon = Fruit(
    id = 7,
    name = "Melancia",
    imageUrl = "https://images.unsplash.com/photo-1589984662646-e7b2e4962f18?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80",
    summary = "Uma fruta grande e redonda com casca verde grossa e polpa suculenta e doce. É uma boa fonte de vitamina C, potássio e licopeno.",
    months = listOf(december, january, february),
    paragraphs = listOf(
        "A melancia é uma fruta refrescante e popular, composta por mais de 90% de água, tornando-a uma opção saudável e hidratante para o verão. Além disso, a melancia é uma excelente fonte de vitaminas e minerais, incluindo vitamina C, vitamina A, potássio e licopeno. O licopeno é um antioxidante que pode ajudar a prevenir danos às células e proteger o corpo contra doenças crônicas.",
        "A melancia também é conhecida por ajudar na saúde cardiovascular, pois o potássio presente na fruta ajuda a regular a pressão arterial e a manter a saúde do coração. A fibra dietética presente na melancia também pode ajudar a regular os níveis de açúcar no sangue e a melhorar a saúde digestiva.",
        "A melancia pode ser consumida fresca ou como ingrediente em saladas de frutas, sobremesas, smoothies e bebidas refrescantes. A fruta é especialmente popular em churrascos, piqueniques e festas de verão, pois é uma opção saudável e refrescante para ajudar a combater o calor. É importante lembrar que, embora a melancia seja uma opção saudável e natural, ela ainda contém açúcares naturais e deve ser consumida com moderação, especialmente para pessoas que precisam controlar os níveis de açúcar no sangue."
    )
)

val grape = Fruit(
    id = 8,
    name = "Uva",
    imageUrl = "https://images.unsplash.com/photo-1637715924886-cbe4485f90b9?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=764&q=80",
    summary = "É rica em antioxidantes, vitaminas e minerais, e é amplamente consumida in natura, em sucos, geleias e vinhos. A uva é conhecida por seus benefícios para a saúde, incluindo a redução do risco de doenças cardiovasculares e do câncer.",
    months = listOf(december, january, february, august, september),
    paragraphs = listOf(
        "A uva é uma fruta doce e suculenta que cresce em cachos em videiras. Ela é rica em nutrientes, incluindo antioxidantes, vitaminas e minerais. As uvas contêm antocianinas, um tipo de antioxidante que ajuda a proteger as células contra danos causados pelos radicais livres. Esses compostos também são responsáveis pela cor escura de algumas variedades de uva, como as uvas vermelhas e roxas.",
        "As uvas também são uma boa fonte de vitaminas C e K, que são importantes para o sistema imunológico e a coagulação sanguínea, respectivamente. Além disso, as uvas são ricas em resveratrol, um composto que pode ajudar a proteger o coração e o sistema nervoso, bem como prevenir o câncer e outras doenças crônicas.",
        "As uvas podem ser consumidas frescas, em saladas de frutas, sucos, vinhos e compotas. Elas também são um ingrediente popular em sobremesas, como tortas, bolos e mousses. As uvas são frequentemente associadas à produção de vinho, e são cultivadas em todo o mundo para esse fim. No entanto, é importante lembrar que o consumo excessivo de álcool pode ter efeitos negativos na saúde, portanto, é importante consumir com moderação. Além disso, as uvas contêm açúcares naturais e devem ser consumidas com moderação por pessoas que precisam controlar os níveis de açúcar no sangue."
    )
)

val fruits = listOf(
    avocado, pineapple, banana, coconut, orange, lemon, papaya, mango, apple, watermelon, grape
)