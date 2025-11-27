package org.example.project.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.serialization.json.Json
import org.example.project.model.KtorWeatherAPI
import org.example.project.model.databaseModule
import org.example.project.viewmodel.MainViewModel
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

//Si besoin du contexte, pour le passer en paramètre
fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(apiModule, databaseModule(), viewModelModule)
    }

// Version pour iOS et Desktop
fun initKoin() = initKoin {}

val apiModule = module {
    //Création d'un singleton pour le client HTTP
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true }, contentType = ContentType.Any)
            }
        }
    }

    //Création d'un singleton pour les repository. Get injectera les instances
    //single { PhotographerAPI(get()) }

    //Nouvelle version avec injection automatique des instances
    //D'abord faire l'import de PhotographerAPI, sinon singleOf n'en voudra pas
    singleOf(::KtorWeatherAPI)
}

//Version spécifique au ViewModel
val viewModelModule = module {
    single{Dispatchers.IO}

    //D'abord faire l'import de MainViewModel, sinon viewModelOf n'en voudra pas
    //viewModelOf(::MainViewModel)
    viewModelOf(::MainViewModel)
}