package org.example.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import meteomultiplateform.composeapp.generated.resources.Res
import meteomultiplateform.composeapp.generated.resources.aldric
import meteomultiplateform.composeapp.generated.resources.app_name
import meteomultiplateform.composeapp.generated.resources.compose_multiplatform
import org.example.project.di.apiModule
import org.example.project.di.viewModelModule
import org.example.project.ui.AppNavigation
import org.example.project.ui.screens.SearchScreen
import org.example.project.ui.theme.AppTheme
import org.example.project.viewmodel.MainViewModel
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.KoinApplication
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    //Démarre Koin sans contexte d'application
    KoinApplication(application = {
        modules(apiModule, viewModelModule)
    }) {
        AppTheme {
            var showContent by remember { mutableStateOf(false) }
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                AppNavigation(modifier = Modifier.padding(innerPadding))
                /*            SearchScreen(modifier = Modifier.padding(innerPadding))*/
            }
            /*Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .safeContentPadding()
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Button(onClick = { showContent = !showContent }) {
                    Text(stringResource(Res.string.app_name))
                }
                AnimatedVisibility(showContent) {
                    val greeting = remember { Greeting().greet() }
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Image(painterResource(Res.drawable.compose_multiplatform), null)
                        Image(painterResource(Res.drawable.aldric), null)
                        Text("Compose: $greeting")
                    }
                }
            }*/
        }}
}