package com.msid.countriesappgrapgql

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.msid.countriesappgrapgql.presentation.CountriesScreen
import com.msid.countriesappgrapgql.ui.theme.CountriesAppGrapgQLTheme
import com.msid.graphqlexample.presentation.CountriesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CountriesAppGrapgQLTheme {


                val viewModel = hiltViewModel<CountriesViewModel>()
                val state by viewModel.state.collectAsState()
                CountriesScreen(
                    state = state,
                    onSelectCountry = viewModel::selectedCountry,
                    onDismissCountryDialog = viewModel::dismissCountryDialog
                    )

            }
        }
    }
}

