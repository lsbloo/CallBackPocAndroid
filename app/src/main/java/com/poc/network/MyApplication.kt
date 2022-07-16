package com.poc.network

import android.app.Application
import com.poc.network.home.data.di.HomeSetup
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyApplication)

            modules(listOf(HomeSetup.setupHome()))
        }
    }
}