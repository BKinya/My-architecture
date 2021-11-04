package com.beatrice.myarchitecture

import android.app.Application
import com.beatrice.myarchitecture.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
// TODO: Add link to the slides in the ReadMe after the talk
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(appModules)
        }
    }
}