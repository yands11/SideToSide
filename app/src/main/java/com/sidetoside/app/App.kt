package com.sidetoside.app

import android.app.Application
import com.sidetoside.app.di.apiModule
import com.sidetoside.app.di.networkModule
import com.sidetoside.app.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber


class App : Application() {

    override fun onCreate() {
        super.onCreate()

        setupTimber()
        setupKoin()
    }

    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    networkModule,
                    apiModule,
                    viewModelModule
                )
            )
        }
    }
}