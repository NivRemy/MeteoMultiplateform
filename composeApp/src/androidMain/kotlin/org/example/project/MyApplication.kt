package org.example.project

import android.app.Application
import org.example.project.di.initKoin
import org.koin.android.ext.koin.androidContext

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        //On démarre Koin avec le context
        initKoin { androidContext(this@MyApplication) }
    }
}