package com.msid.graphqlexample.data

import com.apollographql.apollo3.ApolloClient
import com.msid.CountriesQuery
import com.msid.CountryQuery
import com.msid.graphqlexample.domain.CountryClient
import com.msid.graphqlexample.domain.DetailedCountry
import com.msid.graphqlexample.domain.SimpleCountry

class ApolloCountryClient(
    private val apolloClient: ApolloClient
): CountryClient {
    override suspend fun getCountries(): List<SimpleCountry> {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map { it.toSimpleCountry() }
            ?: emptyList()
    }

    override suspend fun detailedCountry(code: String): DetailedCountry? {
        return apolloClient
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country
            ?.toDetailedCountry()
    }


}