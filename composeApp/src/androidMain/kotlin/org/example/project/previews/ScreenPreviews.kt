package org.example.project.previews

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import org.example.project.di.apiModule
import org.example.project.di.viewModelModule
import org.example.project.model.MainBean
import org.example.project.model.WeatherBean
import org.example.project.model.WeatherDescriptionBean
import org.example.project.model.WindBean
import org.example.project.ui.screens.DetailScreen
import org.example.project.ui.screens.SearchScreen
import org.example.project.ui.theme.AppTheme
import org.example.project.viewmodel.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.compose.KoinApplicationPreview

@Preview(showBackground = true, showSystemUi = true, locale = "fr",
    uiMode = android.content.res.Configuration.UI_MODE_TYPE_NORMAL or android.content.res.Configuration.UI_MODE_TYPE_NORMAL)
@Preview(showBackground = true, showSystemUi = true,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES or android.content.res.Configuration.UI_MODE_TYPE_NORMAL)
@Composable
fun SearchScreenPreview() {
    //Il faut remplacer NomVotreAppliTheme par le thème de votre application
    //Utilisé par exemple dans MainActivity.kt sous setContent {...}
    val context = LocalContext.current
    KoinApplicationPreview(
        application = {
            androidContext(context)
            modules(apiModule, viewModelModule)
        }
    ) {
        AppTheme {
            val mainViewModel: MainViewModel = viewModel()
            mainViewModel.loadFakeData(runInProgress = true, errorMessage = "Une erreur")
            SearchScreen(mainViewModel = mainViewModel)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Preview(showBackground = true, showSystemUi = true,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES
            or android.content.res.Configuration.UI_MODE_TYPE_NORMAL)
@Composable
fun DetailScreenPreview() {
    val context = LocalContext.current
    KoinApplicationPreview(
        application = {
            androidContext(context)
            modules(apiModule, viewModelModule)
        }
    ) {
        AppTheme {
            val mainViewModel: MainViewModel = viewModel()
            DetailScreen(
                //jeu de donnée pour la Preview
                weatherBean = WeatherBean(
                    id = 2,
                    name = "Toulouse",
                    main = MainBean(temp = 22.3),
                    weather = listOf(
                        WeatherDescriptionBean(
                            description = "partiellement nuageux",
                            icon = "https://picsum.photos/201"
                        )
                    ),
                    wind = WindBean(speed = 3.2)
                )
            )
        }
    }
}