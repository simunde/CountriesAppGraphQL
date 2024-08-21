package com.msid.graphqlexample.di

import com.apollographql.apollo3.ApolloClient
import com.msid.graphqlexample.data.ApolloCountryClient
import com.msid.graphqlexample.domain.CountryClient
import com.msid.graphqlexample.domain.GetCountriesUseCase
import com.msid.graphqlexample.domain.GetCountryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient{
        return ApolloClient
            .Builder()
            .serverUrl("https://countries.trevorblades.com/graphql")
            .build()
    }


    @Provides
    @Singleton
    fun provideCountryClient(apolloClient: ApolloClient): CountryClient{
        return ApolloCountryClient(apolloClient)
    }

    @Provides
    @Singleton
    fun provideCountriesUseCase(countryClient: CountryClient): GetCountriesUseCase{
        return GetCountriesUseCase(countryClient)
    }

    @Provides
    @Singleton
    fun provideCountryUseCase(countryClient: CountryClient): GetCountryUseCase{
        return GetCountryUseCase(countryClient)
    }
}