package org.example.project.model

import org.example.project.di.apiModule
import org.example.project.di.viewModelModule
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

//DataBase.kt (dans commonMain/model)
expect fun databaseModule(): Module


