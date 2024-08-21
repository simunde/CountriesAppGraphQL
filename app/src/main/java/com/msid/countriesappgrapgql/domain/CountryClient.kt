package com.msid.graphqlexample.domain


interface CountryClient {

    suspend fun getCountries() : List<SimpleCountry>
    suspend fun detailedCountry(code: String): DetailedCountry?
}