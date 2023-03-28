package me.brisson.domain

import me.brisson.domain.model.Fruit
import me.brisson.domain.model.Month

//TODO: move this to data module as soon as module onBoarding is ready
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
    name = "Abacate",
    imageUrl = "https://images.unsplash.com/photo-1523049673857-eb18f1d7b578?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1075&q=80",
    summary = "Fruta com alto teor de gordura saudável, fonte de vitamina E e ácido oleico. Pode ser consumida in natura ou em preparações.",
    months = listOf(january, february, march, april, may, september)
)

val pineapple = Fruit(
    name = "Abacaxi",
    imageUrl = "https://images.unsplash.com/photo-1589820296156-2454bb8a6ad1?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80",
    summary = "Fruta tropical doce e suculenta, rica em vitamina C e bromelina, uma enzima que ajuda na digestão.",
    months = listOf(january, february, june)
)

val banana = Fruit(
    name = "Banana",
    imageUrl = "https://images.unsplash.com/photo-1571771894821-ce9b6c11b08e?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=880&q=80",
    summary = "Fruta doce e energética, rica em potássio e carboidratos. Pode ser consumida in natura ou em preparações.",
    months = listOf(january, february, march, april, may, june, july, august, september, october, november, december)
)

val coconut = Fruit(
    name = "Coco",
    imageUrl = "https://images.unsplash.com/photo-1560769680-ba2f3767c785?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=764&q=80",
    summary = "O coco é uma fruta tropical muito apreciada por sua água doce e pela polpa branca e carnuda. É uma fruta versátil, que pode ser consumida fresca, seca, ralada ou em forma de leite.",
    months = listOf(january, february, march, april, may, june, july, august, september, october, november, december)
)

val orange = Fruit(
    name = "Laranja",
    imageUrl = "https://images.unsplash.com/photo-1592187270271-9a4b84faa228?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80",
    summary = "Uma fruta cítrica popular e comum, com casca laranja brilhante e polpa suculenta e doce ou azeda. É uma excelente fonte de vitamina C e também contém folato e potássio.",
    months = listOf(june, july, august, september, december, january)
)

val lemon = Fruit(
    name = "Limão",
    imageUrl = "https://images.unsplash.com/photo-1582287104445-6754664dbdb2?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80",
    summary = "Outra fruta cítrica comum, com casca amarela brilhante e polpa ácida e suculenta. É rica em vitamina C, flavonóides e outros antioxidantes.",
    months = listOf(may, june, july, august, september, january, february, march)
)

val papaya = Fruit(
    name = "Mamão",
    imageUrl = "https://images.unsplash.com/photo-1517282009859-f000ec3b26fe?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80",
    summary = "Uma fruta tropical com casca fina e lisa e polpa macia e doce. É rica em vitamina C, carotenoides e enzimas digestivas.",
    months = listOf(january, february, march, july, august, september, october, november)
)

val mango = Fruit(
    name = "Manga",
    imageUrl = "https://images.unsplash.com/photo-1604256913753-eef2d1d8ca21?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1171&q=80",
    summary = "Uma fruta tropical doce e suculenta, com casca fina e lisa e polpa macia e fibrosa. É uma excelente fonte de vitamina C e carotenoides.",
    months = listOf(october, november, december, january, february)
)

val apple = Fruit(
    name = "Maçã",
    imageUrl = "https://images.unsplash.com/photo-1579613832125-5d34a13ffe2a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80",
    summary = "Uma fruta redonda e crocante com casca fina e variando de verde a vermelho, com polpa branca e doce ou levemente ácida. É uma boa fonte de fibra, vitamina C e antioxidantes.",
    months = listOf(january, february, march, april, may, july, august, september, october, november)
)

val watermelon = Fruit(
    name = "Melancia",
    imageUrl = "https://images.unsplash.com/photo-1589984662646-e7b2e4962f18?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80",
    summary = "Uma fruta grande e redonda com casca verde grossa e polpa suculenta e doce. É uma boa fonte de vitamina C, potássio e licopeno.",
    months = listOf(december, january, february)
)

val grape = Fruit(
    name = "Uva",
    imageUrl = "https://images.unsplash.com/photo-1637715924886-cbe4485f90b9?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=764&q=80",
    summary = "É rica em antioxidantes, vitaminas e minerais, e é amplamente consumida in natura, em sucos, geleias e vinhos. A uva é conhecida por seus benefícios para a saúde, incluindo a redução do risco de doenças cardiovasculares e do câncer.",
    months = listOf(december, january, february, august, september)
)

val fruits = listOf(
    avocado, pineapple, banana, coconut, orange, lemon, papaya, mango, apple, watermelon, grape
)