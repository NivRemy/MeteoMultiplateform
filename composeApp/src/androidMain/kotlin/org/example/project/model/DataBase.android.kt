package org.example.project.model

import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import org.example.project.db.MyDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun databaseModule(): Module = module {
    single {
        //trouver le context
        val driver =
            AndroidSqliteDriver(MyDatabase.Schema, get(), "test.db")
        MyDatabase(driver)
    }
}