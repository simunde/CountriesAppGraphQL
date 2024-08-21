package com.msid.graphqlexample.data

import com.msid.CountriesQuery
import com.msid.CountryQuery
import com.msid.graphqlexample.domain.DetailedCountry
import com.msid.graphqlexample.domain.SimpleCountry

fun CountryQuery.Country.toDetailedCountry(): DetailedCountry{
    return DetailedCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No Capital",
        currency = currency ?: "No Currency",
        languages = languages.mapNotNull { it.name },
        continent = continent.name
    )
}

fun CountriesQuery.Country.toSimpleCountry(): SimpleCountry {
    return SimpleCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No Capital"
    )
}