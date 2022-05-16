package com.gklausan.becafilms.domain.model

data class Results(
    val page: Int,
    val results: List<TrendingFilms>,
    val total_pages: Int,
    val total_results: Int
)

fun mockResults() =
    Results(
        1,
        listOf(
            TrendingFilms(
                false,
                "/egoyMDLqCxzjnSrWOz50uLlJWmD.jpg",
                listOf(878),
                675353,
                "movie",
                "en",
                "Sonic the Hedgehog 2",
                "After settling in Green Hills, Sonic is eager to prove he has what it takes to be a true hero. His test comes when Dr. Robotnik returns, this time with a new partner, Knuckles, in search for an emerald that has the power to destroy civilizations. Sonic teams up with his own sidekick, Tails, and together they embark on a globe-trotting journey to find the emerald before it falls into the wrong hands.",
                10135.117,
                "/6DrHO1jr3qVrViUO6s6kFiAGM7.jpg",
                "2022-03-30",
                "Sonic the Hedgehog 2",
                false,
                7.7,
                1019,
            )
        ),
        10,
        10,
    )
